package com.apexon.rms.resourceManagementApplication.controller;

import com.apexon.rms.resourceManagementApplication.dto.DepartmentDTO;
import com.apexon.rms.resourceManagementApplication.entity.Department;
import com.apexon.rms.resourceManagementApplication.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rms/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
