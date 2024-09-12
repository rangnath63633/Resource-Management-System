package com.rms.resourceManagementApplication.dto;

import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.entity.Employee;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjectDTO {

    private String projectName;
    private Client client;
    private List<Employee> employees;
    private Date startDate;
    private String owner;

}
