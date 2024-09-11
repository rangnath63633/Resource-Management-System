package com.apexon.rms.resourceManagementApplication.dto;

import com.apexon.rms.resourceManagementApplication.entity.Department;
import com.apexon.rms.resourceManagementApplication.entity.Project;
import com.apexon.rms.resourceManagementApplication.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class CreateEmployeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private Long departmentId;

}
