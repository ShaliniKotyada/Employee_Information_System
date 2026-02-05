package com.example.employee_information_system.dto;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


public class JobHistoryRequestDTO {
    


    @NotNull

    private Long empId;

    @NotNull
    private Long jobId;

    @NotNull
      @JsonFormat(pattern = "yyyy-MM-dd")
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
