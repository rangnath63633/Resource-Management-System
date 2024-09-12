package com.rms.resourceManagementApplication.service;

import com.rms.resourceManagementApplication.Mapper.ProjectMapper;
import com.rms.resourceManagementApplication.dto.CreateProjectDTO;
import com.rms.resourceManagementApplication.dto.ProjectDTO;
import com.rms.resourceManagementApplication.entity.Project;
import com.rms.resourceManagementApplication.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectMapper projectMapper;

    private final ProjectRepository projectRepository;

    public Project createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toProject(projectDTO);
        return projectRepository.save(project);
    }

    public Project createProjectWithClientId(CreateProjectDTO createProjectDTO) {
        Project project = projectMapper.toProjectWithClientId(createProjectDTO);
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectByOwner(String owner) {
        return projectRepository.findByOwner(owner);
    }


    public Project createProjectWithClientIdAndEmployeeId(CreateProjectDTO createProjectDTO) {
        Project project = projectMapper.toProjectWithClientIdandEmployeeId(createProjectDTO);
        return projectRepository.save(project);
    }

}
