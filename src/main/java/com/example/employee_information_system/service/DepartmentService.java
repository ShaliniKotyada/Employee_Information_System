package com.example.employee_information_system.service;

import java.util.List;

import com.example.employee_information_system.dto.DepartmentResponseDTO;
import com.example.employee_information_system.entity.Department;

public interface DepartmentService {
    List<DepartmentResponseDTO> getAllDepartments();
}
