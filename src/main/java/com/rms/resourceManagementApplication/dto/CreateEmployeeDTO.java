package com.rms.resourceManagementApplication.dto;

import lombok.Data;

@Data
public class CreateEmployeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private Long departmentId;

}
