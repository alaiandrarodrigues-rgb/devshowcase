package br.edu.uapi.devshowcase;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final FeedbackRepository feedbackRepository;

    public ProjectService(ProjectRepository projectRepository, FeedbackRepository feedbackRepository) {
        this.projectRepository = projectRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Transactional
    public Feedback addFeedback(Long projectId, FeedbackRequest request) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado: " + projectId));

        Feedback feedback = new Feedback(request.rating(), request.comment(), project);
        Feedback saved = feedbackRepository.save(feedback);

        Double average = feedbackRepository.findAverageRatingByProject(project);
        project.setAverageRating(average == null ? 0.0 : Math.round(average * 100.0) / 100.0);
        projectRepository.save(project);

        return saved;
    }

    @Transactional
    public Project upvote(Long projectId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado: " + projectId));
        project.setUpvotes(project.getUpvotes() + 1);
        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public Page<Project> list(String technology, int page, int size) {
        if (page < 0) throw new IllegalArgumentException("A página deve ser maior ou igual a 0.");
        if (size < 1 || size > 50) throw new IllegalArgumentException("O tamanho deve estar entre 1 e 50.");
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return technology == null || technology.isBlank()
            ? projectRepository.findAll(pageable)
            : projectRepository.findByTechnologyContainingIgnoreCase(technology, pageable);
    }
}
