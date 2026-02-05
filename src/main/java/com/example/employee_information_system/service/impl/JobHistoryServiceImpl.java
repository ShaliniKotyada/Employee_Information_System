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

@Service
public class JobHistoryServiceImpl implements JobHistoryService{
    
    private final JobHistoryRepository historyRepository;
    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    public JobHistoryServiceImpl( JobHistoryRepository historyRepository,
        EmployeeRepository employeeRepository,
        JobRepository jobRepository){
            this.historyRepository = historyRepository;
            this.employeeRepository= employeeRepository;
            this.jobRepository= jobRepository;
        }

        @Override
        public List<JobHistoryResponseDTO> getJobHistoryByEmployee(Long empId){

            List<JobHistory> list=historyRepository.findByEmployee_Id(empId);
            List<JobHistoryResponseDTO> response= new ArrayList<>();
            for(JobHistory jobHistory: list){
                JobHistoryResponseDTO responseDto = new JobHistoryResponseDTO(
                    jobHistory.getId(), jobHistory.getEmployee().getId(),
                    jobHistory.getJob().getId() , jobHistory.getStartDate(), 
                    jobHistory.getEndDate());
                    response.add(responseDto);
            }
            return response;

        }

    @Override
    public void addJobHistory(JobHistoryRequestDTO request) {
        // TODO Auto-generated method stub
       Employee employee = employeeRepository.findById(request.getEmpId())
       .orElseThrow(()-> new RuntimeException("Employee not found"));

       Job job= jobRepository.findById(request.getJobId())
       .orElseThrow(()-> new RuntimeException("Job not found"));

       JobHistory history= new JobHistory();
       history.setEmployee(employee);
       history.setJob(job);
       history.setStartDate(request.getStartDate());
       history.setEndDate(request.getEndDate());

       historyRepository.save(history);
    }

    // @Override
    // public void addJobHistory(JobHistoryRequestDTO request) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addJobHistory'");

        
    // }
}
