package com.rms.resourceManagementApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "projectId")
    )
    private List<Project> projects;
}
