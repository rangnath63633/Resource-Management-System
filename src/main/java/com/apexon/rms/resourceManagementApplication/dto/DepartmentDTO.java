package com.apexon.rms.resourceManagementApplication.dto;


import com.apexon.rms.resourceManagementApplication.entity.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartmentDTO {

    private Long departmentId;
    private String departmentName;
    private List<Employee> employees;
}
