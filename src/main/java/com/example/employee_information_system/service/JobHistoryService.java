package com.example.employee_information_system.service;

import java.util.List;

import com.example.employee_information_system.dto.JobHistoryRequestDTO;
import com.example.employee_information_system.dto.JobHistoryResponseDTO;
import com.example.employee_information_system.entity.JobHistory;

public interface JobHistoryService {
    
    List<JobHistoryResponseDTO> getJobHistoryByEmployee(Long empId);

    void addJobHistory(JobHistoryRequestDTO request);
}
