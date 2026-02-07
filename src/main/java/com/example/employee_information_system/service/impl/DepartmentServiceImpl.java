package com.example.employee_information_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_information_system.dto.DepartmentResponseDTO;
import com.example.employee_information_system.mapper.DepartmentMapper;
import com.example.employee_information_system.repository.DepartmentRepository;
import com.example.employee_information_system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    

    public DepartmentServiceImpl(DepartmentMapper departmentMapper, DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments(){
        return departmentMapper.toDTOList(departmentRepository.findAll());

    }
}
