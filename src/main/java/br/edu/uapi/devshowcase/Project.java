package br.edu.uapi.devshowcase;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String technology;

    @Column(nullable = false)
    private Integer upvotes = 0;

    @Column(nullable = false)
    private Double averageRating = 0.0;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    public Project() {}

    public Project(String name, String description, String technology) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.upvotes = 0;
        this.averageRating = 0.0;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getTechnology() { return technology; }
    public Integer getUpvotes() { return upvotes; }
    public Double getAverageRating() { return averageRating; }
    public List<Feedback> getFeedbacks() { return feedbacks; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setTechnology(String technology) { this.technology = technology; }
    public void setUpvotes(Integer upvotes) { this.upvotes = upvotes; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
}
