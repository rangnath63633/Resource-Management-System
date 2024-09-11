package com.apexon.rms.resourceManagementApplication.repository;

import com.apexon.rms.resourceManagementApplication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
