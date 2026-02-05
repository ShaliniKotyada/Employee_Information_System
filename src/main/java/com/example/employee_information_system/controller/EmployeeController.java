package com.example.employee_information_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_information_system.entity.Employee;
import com.example.employee_information_system.service.EmployeeService;
import com.example.employee_information_system.dto.EmployeeResponseDTO;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    @GetMapping("/job/{jobId}")
    public List<EmployeeResponseDTO> getByJob(@PathVariable Long jobId){
        return employeeService.getEmployeesByJob(jobId);
    }


    // get employees by deptId
    @GetMapping("/department/{deptId}")
    public List<EmployeeResponseDTO> getByDepartment(@PathVariable Long deptId){
        return employeeService.getEmployeesByDepartment(deptId);
    }

    // get employee name that contains the string
    @GetMapping("/search")
    public List<EmployeeResponseDTO> getMethodName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    // get employee whose salary is within the range
    @GetMapping("/salary")
    public List<EmployeeResponseDTO> getBySalaryRange(
        @RequestParam double min,
        @RequestParam double max){
            return employeeService.getBySalaryRange(min, max);
        }
    
    // Employees greater then the given salary range
    @GetMapping("/experience")
    public List<EmployeeResponseDTO> getByExperience(@RequestParam int years){
        return employeeService.getByExperienceGreaterThan(years);
    }

    // update salary by employee Id
    @PatchMapping("/{empId}/salary")
    public String updateSalary(
        @PathVariable Long empId,
        @RequestParam double salary){
             employeeService.updateSalary(empId, salary);
             return "Salary updated successfully";
        }
}
