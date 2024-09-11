package com.apexon.rms.resourceManagementApplication.dto;

import com.apexon.rms.resourceManagementApplication.entity.Department;
import com.apexon.rms.resourceManagementApplication.entity.Project;
import com.apexon.rms.resourceManagementApplication.entity.Role;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Data
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;

}
