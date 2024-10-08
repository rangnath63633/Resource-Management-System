package com.rms.resourceManagementApplication.service;

import com.rms.resourceManagementApplication.Mapper.EmployeeMapper;
import com.rms.resourceManagementApplication.dto.CreateEmployeeDTO;
import com.rms.resourceManagementApplication.dto.EmployeeDTO;
import com.rms.resourceManagementApplication.entity.Employee;
import com.rms.resourceManagementApplication.entity.Project;
import com.rms.resourceManagementApplication.repository.EmployeeRepository;
import com.rms.resourceManagementApplication.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentService departmentService;
    private final ProjectRepository projectRepository;

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

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public Employee addProjectToEmployee(Long employeeId, Long projectId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        Project project = projectRepository.findById(projectId).orElse(null);
        assert employee != null;
        assert project != null;
        employee.setProjects(new ArrayList<>(List.of(project)));
        return employeeRepository.save(employee);
    }


}
