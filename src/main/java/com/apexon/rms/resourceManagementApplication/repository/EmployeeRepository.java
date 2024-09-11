package com.apexon.rms.resourceManagementApplication.repository;

import com.apexon.rms.resourceManagementApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
