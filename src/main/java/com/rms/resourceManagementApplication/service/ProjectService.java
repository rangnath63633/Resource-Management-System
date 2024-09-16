package com.rms.resourceManagementApplication.service;

import com.rms.resourceManagementApplication.Mapper.ProjectMapper;
import com.rms.resourceManagementApplication.dto.CreateProjectDTO;
import com.rms.resourceManagementApplication.dto.ProjectDTO;
import com.rms.resourceManagementApplication.entity.Employee;
import com.rms.resourceManagementApplication.entity.Project;
import com.rms.resourceManagementApplication.repository.EmployeeRepository;
import com.rms.resourceManagementApplication.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectMapper projectMapper;

    private final ProjectRepository projectRepository;

    private final EmployeeRepository employeeRepository;

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

    public Project getProjectById(Long Id) {
        return projectRepository.findById(Id).orElse(null);
    }

    public Project addEmployeeToProject(Long employeeId, Long projectId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        Project project = projectRepository.findById(projectId).orElse(null);
        assert project != null;
        if (project.getEmployees() == null && project.getEmployees().isEmpty()) {
            project.setEmployees(new ArrayList<>(List.of(employee)));
        } else {
            List<Employee> employeeList = project.getEmployees();
            employeeList.add(employee);
        }
        return projectRepository.save(project);
    }

    public void toCheckEmployeeInProject(Long id) {
    }
}
