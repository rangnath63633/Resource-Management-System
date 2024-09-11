package com.apexon.rms.resourceManagementApplication.service;

import com.apexon.rms.resourceManagementApplication.Mapper.EmployeeMapper;
import com.apexon.rms.resourceManagementApplication.dto.CreateEmployeeDTO;
import com.apexon.rms.resourceManagementApplication.dto.DepartmentDTO;
import com.apexon.rms.resourceManagementApplication.dto.EmployeeDTO;
import com.apexon.rms.resourceManagementApplication.entity.Employee;
import com.apexon.rms.resourceManagementApplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentService departmentService;

    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

//    public Employee createEmployeeWithDepartment(CreateEmployeeDTO createEmployeeDTO){
//        Employee employee = employeeMapper.toEmployee(createEmployeeDTO);
//        return employeeRepository.save(employee);
//    }

    public Employee createEmployeeWithDepartment(CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = employeeMapper.toEmployeeWithDepartment(createEmployeeDTO);
        return employeeRepository.save(employee);

//        Mappers.getMapper(EmployeeMapperInterface.class);
//        Employee employee = getMapper().createEmployeeDtoToEmployee(createEmployeeDTO);
//        employeeRepository.save(employee);

        //return departmentService.findByDepartmentId(employee.getDepartment().getDepartmentId());
    }
}
