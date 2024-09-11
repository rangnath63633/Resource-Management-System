package com.apexon.rms.resourceManagementApplication.Mapper;

import com.apexon.rms.resourceManagementApplication.dto.CreateEmployeeDTO;
import com.apexon.rms.resourceManagementApplication.dto.EmployeeDTO;
import com.apexon.rms.resourceManagementApplication.entity.Department;
import com.apexon.rms.resourceManagementApplication.entity.Employee;
import com.apexon.rms.resourceManagementApplication.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeMapper {

    private final DepartmentRepository departmentRepository;


    public Employee toEmployee(EmployeeDTO employeeDTO){
        return Employee.builder().firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phoneNo(employeeDTO.getPhoneNo())
                .build();
    }

    public Employee toEmployeeWithDepartment(CreateEmployeeDTO employeeDTO){
        return Employee.builder().firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phoneNo(employeeDTO.getPhoneNo())
                .department(getDepartment(employeeDTO.getDepartmentId()))
                .build();
    }


    private Department getDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return department;
    }
}
