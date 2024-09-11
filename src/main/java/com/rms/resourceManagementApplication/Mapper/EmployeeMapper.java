package com.rms.resourceManagementApplication.Mapper;

import com.rms.resourceManagementApplication.dto.CreateEmployeeDTO;
import com.rms.resourceManagementApplication.dto.EmployeeDTO;
import com.rms.resourceManagementApplication.entity.Department;
import com.rms.resourceManagementApplication.entity.Employee;
import com.rms.resourceManagementApplication.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
