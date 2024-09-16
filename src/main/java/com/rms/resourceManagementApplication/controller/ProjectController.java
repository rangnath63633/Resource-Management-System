package com.rms.resourceManagementApplication.controller;
import com.rms.resourceManagementApplication.dto.CreateProjectDTO;
import com.rms.resourceManagementApplication.dto.ProjectDTO;
import com.rms.resourceManagementApplication.entity.Employee;
import com.rms.resourceManagementApplication.entity.Project;
import com.rms.resourceManagementApplication.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rms/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }

    @PostMapping("/createWithClientId")
    public ResponseEntity<Project> createProjectWithClientId(@RequestBody CreateProjectDTO createProjectDTO) {
        return ResponseEntity.ok(projectService.createProjectWithClientId(createProjectDTO));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/owner/{owner}")
    public ResponseEntity<List<Project>> getProjectByOwner(@PathVariable String owner) {
        return ResponseEntity.ok(projectService.getProjectByOwner(owner));
    }

    @GetMapping("/getById/{Id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long Id) {
        return ResponseEntity.ok(projectService.getProjectById(Id));
    }


    @PostMapping("/createWithClientIdAndEmployeeId")
    public ResponseEntity<Project> createProjectWithClientIdAndEmployeeId(@RequestBody CreateProjectDTO createProjectDTO) {
        return ResponseEntity.ok(projectService.createProjectWithClientIdAndEmployeeId(createProjectDTO));
    }

    @PostMapping("/{employeeId}/{projectId}")
    public ResponseEntity<Project> addEmployeeToProject(@PathVariable Long employeeId, @PathVariable Long projectId){
        Project project = projectService.addEmployeeToProject(employeeId, projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<String> toCheckEmployeeInProject(@PathVariable Long id){
//        projectService.toCheckEmployeeInProject(id);
//    }
}
