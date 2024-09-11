package com.apexon.rms.resourceManagementApplication.service;


import com.apexon.rms.resourceManagementApplication.Mapper.DepartmentMapper;
import com.apexon.rms.resourceManagementApplication.dto.DepartmentDTO;
import com.apexon.rms.resourceManagementApplication.entity.Department;
import com.apexon.rms.resourceManagementApplication.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toDepartment(departmentDTO);
        return departmentRepository.save(department);
    }

    public DepartmentDTO findByDepartmentId(Long departmentId) {

        Department department = departmentRepository.findById(departmentId).orElse(null);
//        return department != null ? getMapper().departmentToDepartmentDTOs(department) : null;
        return department != null ? departmentMapper.departmentToDepartmentDTOs(department) : null;
    }
}
