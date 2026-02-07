package com.example.employee_information_system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_information_system.dto.JobHistoryRequestDTO;
import com.example.employee_information_system.dto.JobHistoryResponseDTO;
import com.example.employee_information_system.entity.Employee;
import com.example.employee_information_system.entity.Job;
import com.example.employee_information_system.entity.JobHistory;
import com.example.employee_information_system.repository.EmployeeRepository;
import com.example.employee_information_system.repository.JobHistoryRepository;
import com.example.employee_information_system.repository.JobRepository;
import com.example.employee_information_system.service.JobHistoryService;
import com.example.employee_information_system.mapper.JobHistoryMapper;


@Service
public class JobHistoryServiceImpl implements JobHistoryService{
    
    private final JobHistoryRepository historyRepository;
    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final JobHistoryMapper jobHistoryMapper;

    public JobHistoryServiceImpl( JobHistoryRepository historyRepository,
        EmployeeRepository employeeRepository,
        JobRepository jobRepository,JobHistoryMapper jobHistoryMapper){
            this.historyRepository = historyRepository;
            this.employeeRepository= employeeRepository;
            this.jobRepository= jobRepository;
            this.jobHistoryMapper= jobHistoryMapper;
        }

        @Override
        public List<JobHistoryResponseDTO> getJobHistoryByEmployee(Long empId){

           return jobHistoryMapper.toDTOList(historyRepository.findByEmployee_Id(empId));

        }

    @Override
    public void addJobHistory(JobHistoryRequestDTO request) {
        // TODO Auto-generated method stub
       Employee employee = employeeRepository.findById(request.getEmpId())
       .orElseThrow(()-> new RuntimeException("Employee not found"));

       Job job= jobRepository.findById(request.getJobId())
       .orElseThrow(()-> new RuntimeException("Job not found"));

    //    JobHistory history= new JobHistory();
    //    history.setEmployee(employee);
    //    history.setJob(job);
    //    history.setStartDate(request.getStartDate());
    //    history.setEndDate(request.getEndDate());
        
       JobHistory history = jobHistoryMapper.toEntity(request);

        history.setEmployee(employee);
        history.setJob(job);

       historyRepository.save(history);
    }

    // @Override
    // public void addJobHistory(JobHistoryRequestDTO request) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addJobHistory'");

        
    // }
}
