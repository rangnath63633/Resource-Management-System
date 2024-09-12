package com.rms.resourceManagementApplication.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateProjectDTO {

    private String projectName;
    private Long clientId;
    private Long employeeId;
    private Date startDate;
    private String owner;
}
