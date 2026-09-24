package br.edu.uapi.devshowcase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    long countByProject(Project project);
    Double findAverageRatingByProject(Project project);
}
