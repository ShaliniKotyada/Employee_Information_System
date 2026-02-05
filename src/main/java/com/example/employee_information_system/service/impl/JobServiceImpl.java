package com.example.employee_information_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_information_system.entity.Job;
import com.example.employee_information_system.repository.JobRepository;
import com.example.employee_information_system.service.JobService;


@Service
public class JobServiceImpl implements JobService{
    
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository= jobRepository;
    }

    @Override
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
    
}
