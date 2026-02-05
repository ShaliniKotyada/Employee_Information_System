package com.example.employee_information_system.service;

import java.util.List;

import com.example.employee_information_system.dto.EmployeeResponseDTO;
import com.example.employee_information_system.entity.Employee;

public interface EmployeeService {
    List<EmployeeResponseDTO> getEmployeesByJob(Long jobId);

    List<EmployeeResponseDTO> getEmployeesByDepartment(Long deptId);

    List<EmployeeResponseDTO> searchByName(String name);

    List<EmployeeResponseDTO> getBySalaryRange(double min, double max);

    List<EmployeeResponseDTO> getByExperienceGreaterThan(int years);

    void updateSalary(Long empId, double salary);
    
}
