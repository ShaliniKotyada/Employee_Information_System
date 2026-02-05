package com.example.employee_information_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_information_system.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
}
