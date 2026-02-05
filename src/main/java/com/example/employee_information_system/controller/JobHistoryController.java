package com.example.employee_information_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_information_system.dto.JobHistoryRequestDTO;
import com.example.employee_information_system.dto.JobHistoryResponseDTO;
import com.example.employee_information_system.entity.JobHistory;
import com.example.employee_information_system.service.JobHistoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/jobhistory")
public class JobHistoryController {
    
    private final JobHistoryService jobHistoryService;

    public JobHistoryController(JobHistoryService jobHistoryService)
    {
        this.jobHistoryService= jobHistoryService;
    }

    // List of jobhistory by employee
    @GetMapping("/{empId}")
    public List<JobHistoryResponseDTO> getHistory(@PathVariable Long empId){
        return jobHistoryService.getJobHistoryByEmployee(empId);
    }

    // Add a new Job hhistory
    @PostMapping
    public ResponseEntity<String> addJobHistory(@RequestBody JobHistoryRequestDTO request) {
        //TODO: process POST request
        jobHistoryService.addJobHistory(request);
        return ResponseEntity.ok("Job History added successfully");
    }
    
}