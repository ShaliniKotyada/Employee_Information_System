package com.example.employee_information_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_information_system.entity.Employee;
import com.example.employee_information_system.service.EmployeeService;
import com.example.employee_information_system.dto.EmployeeResponseDTO;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;




@RestController
@RequestMapping("/api/employee")
@Validated
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<EmployeeResponseDTO>> getByJob(@PathVariable 
        @NotNull(message="Job Id must not be null")
        @Positive(message="Job Id can't be negative")
        Long jobId){
        return ResponseEntity.ok(employeeService.getEmployeesByJob(jobId));
    }


    // get employees by deptId
    @GetMapping("/department/{deptId}")
    public List<EmployeeResponseDTO> getByDepartment(@PathVariable 
        @Positive(message="department Id must be positive")
        @NotNull(message="department Id must be not null")
        Long deptId){
        return employeeService.getEmployeesByDepartment(deptId);
    }

    // get employee name that contains the string
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponseDTO>> getMethodName(@RequestParam 
        @NotBlank(message="Name must not be null")
        @Size(max=900,message="Name must not be this lengthy")
        String name) {
        return ResponseEntity.ok(employeeService.searchByName(name));
    }

    // get employee whose salary is within the range
    @GetMapping("/salary")
    public ResponseEntity<List<EmployeeResponseDTO>> getBySalaryRange(
        @RequestParam 
        @NotNull(message="minimum range must be not null")
        @PositiveOrZero(message="minimum range must not be negative")
        double min,
        @RequestParam 
        @NotNull(message="maximum range must be not null")
        @Positive(message="maximum range must be positive")
        double max){
            return ResponseEntity.ok(employeeService.getBySalaryRange(min, max));
        }
    
    // Employees greater then the given salary range
    @GetMapping("/experience")
    public ResponseEntity<List<EmployeeResponseDTO>> getByExperience(@RequestParam 
        @NotNull(message="Year must not be null")
        @Positive(message="year must be positive")
        int years){
        return ResponseEntity.ok(employeeService.getByExperienceGreaterThan(years));
    }

    // update salary by employee Id
    @PatchMapping("/{empId}/salary")
    public ResponseEntity<String> updateSalary(
        @PathVariable 
        @NotNull(message="Employee Id must not be null")
        @Positive(message="Employee Id must be positive")
        Long empId,
        @RequestParam 
        @NotNull(message="Salary must be not null")
        @Positive(message="Salary must not be negative")
        double salary){
             employeeService.updateSalary(empId, salary);
             return ResponseEntity.ok("Salary updated successfully");
        }
}
