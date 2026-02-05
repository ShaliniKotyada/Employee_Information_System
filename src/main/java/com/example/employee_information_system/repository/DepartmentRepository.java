package com.example.employee_information_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_information_system.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
 {
    
}
