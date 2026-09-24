package br.edu.uapi.devshowcase;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<?> feedback(@PathVariable Long id, @Valid @RequestBody FeedbackRequest request) {
        Feedback saved = service.addFeedback(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
            "message", "Feedback cadastrado com sucesso.",
            "feedbackId", saved.getId(),
            "rating", saved.getRating(),
            "comment", saved.getComment()
        ));
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<?> upvote(@PathVariable Long id) {
        Project project = service.upvote(id);
        return ResponseEntity.ok(Map.of(
            "message", "Curtida registrada com sucesso.",
            "projectId", project.getId(),
            "upvotes", project.getUpvotes()
        ));
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponse>> list(
        @RequestParam(required = false) String technology,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Page<ProjectResponse> result = service.list(technology, page, size).map(ProjectResponse::from);
        return ResponseEntity.ok(result);
    }
}
