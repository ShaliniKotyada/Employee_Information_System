package com.example.employee_information_system.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Job {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
   

    private String title;
    @JsonIgnore
    @OneToMany(mappedBy="job")
    private List<JobHistory> jobHistory;
    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private List<Employee> employees;

     public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public List<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(List<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
