package com.rms.resourceManagementApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

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
    @ManyToMany(mappedBy = "employees", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Project> projects;
}
