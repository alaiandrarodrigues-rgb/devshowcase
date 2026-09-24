package br.edu.uapi.devshowcase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    long countByProject(Project project);

    @Query("SELECT AVG(f.rating) FROM Feedback f WHERE f.project = :project")
    Double findAverageRatingByProject(@Param("project") Project project);
}
