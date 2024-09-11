package com.rms.resourceManagementApplication.Mapper;

import com.rms.resourceManagementApplication.dto.DepartmentDTO;
import com.rms.resourceManagementApplication.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {

    public Department toDepartment(DepartmentDTO departmentDTO) {
        return Department.builder().departmentName(departmentDTO.getDepartmentName())
//                .employees(departmentDTO.getEmployees())
                .build();
    }

    public DepartmentDTO departmentToDepartmentDTOs(Department department)
    {
        return DepartmentDTO.builder().departmentName(department.getDepartmentName())
                //.employees(department.getEmployees())
                .build();
    }
}
