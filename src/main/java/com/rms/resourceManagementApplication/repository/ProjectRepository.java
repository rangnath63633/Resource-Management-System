package com.rms.resourceManagementApplication.repository;

import com.rms.resourceManagementApplication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
