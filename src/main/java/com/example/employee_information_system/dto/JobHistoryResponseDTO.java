package com.example.employee_information_system.dto;

import java.time.LocalDate;

public class JobHistoryResponseDTO {
    
    private long id;
    private long jobId;
    private long empId;
    private LocalDate startDate;
    private LocalDate endDate;

    public JobHistoryResponseDTO(long id, long jobId, long empId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.jobId = jobId;
        this.empId = empId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStarDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


}
