package br.edu.uapi.devshowcase;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findByTechnologyContainingIgnoreCase(String technology, Pageable pageable);
}
