package com.example.employee_information_system.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee_information_system.dto.EmployeeResponseDTO;
import com.example.employee_information_system.entity.Employee;
import com.example.employee_information_system.repository.EmployeeRepository;
import com.example.employee_information_system.service.EmployeeService;
import com.example.employee_information_system.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
    EmployeeMapper employeeMapper
    )
    {
        this.employeeRepository= employeeRepository;
        this.employeeMapper= employeeMapper;
    }
    

    @Override
    public List<EmployeeResponseDTO> getEmployeesByJob(Long jobId){
       return employeeMapper.toDTOList(employeeRepository.findByJob_Id(jobId));
       
       
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByDepartment(Long deptId){
       return employeeMapper.toDTOList(employeeRepository.findByDept_Id(deptId));
       
    }
    

    @Override
    public List<EmployeeResponseDTO> searchByName(String name) {
        // TODO
        return employeeMapper.toDTOList(employeeRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    public List<EmployeeResponseDTO> getBySalaryRange(double min, double max) {
        // TODO
        return employeeMapper.toDTOList(employeeRepository.findBySalaryBetween(min, max));
    }

    @Override
    public List<EmployeeResponseDTO> getByExperienceGreaterThan(int years) {
        // TODO
        LocalDate date= LocalDate.now().minusYears(years);
        return employeeMapper.toDTOList(employeeRepository.findByDateOfJoiningBefore(date));
    }

    @Override
    public void updateSalary(Long empId, double salary) {
        // TODO
        Employee emp= employeeRepository.findById(empId)
        .orElseThrow(()-> new RuntimeException("Employee not found"));

        emp.setSalary(salary);
        employeeRepository.save(emp);
    }
}
