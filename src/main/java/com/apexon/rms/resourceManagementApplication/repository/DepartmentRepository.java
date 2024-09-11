package com.apexon.rms.resourceManagementApplication.repository;

import com.apexon.rms.resourceManagementApplication.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
