package com.example.employee_information_system.dto;

import java.time.LocalDate;

public class JobHistoryResponseDTO {
    
    private long id;
    private long jobId;
    private long empId;
    private LocalDate starDate;
    private LocalDate endDate;

    public JobHistoryResponseDTO(long id, long jobId, long empId, LocalDate starDate, LocalDate endDate) {
        this.id = id;
        this.jobId = jobId;
        this.empId = empId;
        this.starDate = starDate;
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

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


}
