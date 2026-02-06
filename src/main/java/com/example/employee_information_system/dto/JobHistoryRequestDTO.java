package com.example.employee_information_system.dto;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
public class JobHistoryRequestDTO {
    @NotNull(message="Employee ID must not be null")
    private Long empId;
    @NotNull(message="Job ID must not be null")
    private Long jobId;
      @JsonFormat(pattern = "yyyy-MM-dd")
      @PastOrPresent(message="Start Date must not be of future")
      @NotNull(message="Start date must not be null")
    private LocalDate startDate;
      @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    // getters & setters

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

   
}
