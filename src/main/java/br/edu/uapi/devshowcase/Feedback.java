package br.edu.uapi.devshowcase;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false, length = 1000)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    public Feedback() {}

    public Feedback(Integer rating, String comment, Project project) {
        this.rating = rating;
        this.comment = comment;
        this.project = project;
    }

    public Long getId() { return id; }
    public Integer getRating() { return rating; }
    public String getComment() { return comment; }
    public Project getProject() { return project; }
}
