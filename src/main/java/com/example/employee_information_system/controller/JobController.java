package com.example.employee_information_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_information_system.entity.Job;
import com.example.employee_information_system.service.JobService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService=jobService;
    }
    
    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    

    
}
