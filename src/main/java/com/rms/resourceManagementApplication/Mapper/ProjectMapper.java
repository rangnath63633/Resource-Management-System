package com.rms.resourceManagementApplication.Mapper;

import com.rms.resourceManagementApplication.dto.ProjectDTO;
import com.rms.resourceManagementApplication.entity.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {

    public Project toProject(ProjectDTO projectDTO) {
        return Project.builder().projectName(projectDTO.getProjectName())
                .client(projectDTO.getClient())
                .employees(projectDTO.getEmployees()).build();
    }
}
