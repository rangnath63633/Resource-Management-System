package com.apexon.rms.resourceManagementApplication.entity;

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
@Table(name="projects")
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String projectName;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;
}
