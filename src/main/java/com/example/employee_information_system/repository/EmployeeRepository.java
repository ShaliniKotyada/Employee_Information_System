package com.example.employee_information_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_information_system.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Employee by job
    List<Employee> findByJob_Id(Long jobId);

    // Employees by Department
    List<Employee> findByDept_Id(Long deptId);

    // Name conataining
    List<Employee> findByNameContainingIgnoreCase(String name);

    // salary Range
    List<Employee> findBySalaryBetween(double min, double max);

    //Experience > given years
    List<Employee> findByDateOfJoiningBefore(LocalDate date);
    
    
}
