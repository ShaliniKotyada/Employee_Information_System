package com.example.employee_information_system.dto;

import java.time.LocalDate;

public class EmployeeResponseDTO {
    
    private long id;
    private String name;
    private long jobId;
    private LocalDate DateOfJoining;
    private long deptId;
    private double salary;
    public EmployeeResponseDTO(long id,String name,long jobId,LocalDate Date,long deptId,double salary){
        this.id=id;
        this.name=name;
        this.jobId=jobId;
        this.DateOfJoining=Date;
        this.deptId=deptId;
        this.salary=salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public LocalDate getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(LocalDate DateOfJoining) {
        this.DateOfJoining = DateOfJoining;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    

}
