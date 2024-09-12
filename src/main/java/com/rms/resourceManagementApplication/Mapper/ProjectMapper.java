package com.rms.resourceManagementApplication.Mapper;

import com.rms.resourceManagementApplication.dto.CreateProjectDTO;
import com.rms.resourceManagementApplication.dto.ProjectDTO;
import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.entity.Employee;
import com.rms.resourceManagementApplication.entity.Project;
import com.rms.resourceManagementApplication.repository.ClientRepository;
import com.rms.resourceManagementApplication.repository.EmployeeRepository;
import com.rms.resourceManagementApplication.service.ClientService;
import com.rms.resourceManagementApplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectMapper {

    private final ClientService clientService;

    private final EmployeeService employeeService;

    private final EmployeeRepository employeeRepository;

    private final ClientRepository clientRepository;

    public Project toProject(ProjectDTO projectDTO) {
        return Project.builder().projectName(projectDTO.getProjectName())
                .client(projectDTO.getClient())
                .employees(projectDTO.getEmployees())
                .owner(projectDTO.getOwner())
                .startDate(projectDTO.getStartDate())
                .build();
    }

    public Project toProjectWithClientId(CreateProjectDTO createProjectDTO) {
        return Project.builder().projectName(createProjectDTO.getProjectName())
                .owner(createProjectDTO.getOwner())
                .startDate(createProjectDTO.getStartDate())
                .client(clientService.findByClientId(createProjectDTO.getClientId()))
                .build();
    }

    public Project toProjectWithClientIdandEmployeeId(CreateProjectDTO createProjectDTO) {
        return Project.builder().projectName(createProjectDTO.getProjectName())
                .owner(createProjectDTO.getOwner())
                .startDate(createProjectDTO.getStartDate())
                .client(clientRepository.findById(createProjectDTO.getClientId()).orElse(null))
                .employees(new ArrayList<>(List.of(employeeRepository.findById(createProjectDTO.getEmployeeId()).orElse(new Employee()))))
                .build();
 }
}
