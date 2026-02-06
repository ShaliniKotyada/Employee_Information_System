package com.example.employee_information_system.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee_information_system.dto.EmployeeResponseDTO;
import com.example.employee_information_system.entity.Employee;
import com.example.employee_information_system.repository.EmployeeRepository;
import com.example.employee_information_system.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByJob(Long jobId){
       List<Employee> list= employeeRepository.findByJob_Id(jobId);
       
        List<EmployeeResponseDTO> response=new ArrayList<>();
        for(Employee emp:list){
            EmployeeResponseDTO responseDto=new EmployeeResponseDTO(
                emp.getId(),emp.getName(),emp.getJob().getId(),emp.getDateOfJoining(),
                emp.getDept().getId(),emp.getSalary()
            );
            response.add(responseDto);

        }
        return response;
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByDepartment(Long deptId){
       List<Employee> list=employeeRepository.findByDept_Id(deptId);
       List<EmployeeResponseDTO> response=new ArrayList<>();
        for(Employee emp:list){
            EmployeeResponseDTO responseDto=new EmployeeResponseDTO(
                emp.getId(),emp.getName(),emp.getJob().getId(),emp.getDateOfJoining(),
                emp.getDept().getId(),emp.getSalary()
            );
            response.add(responseDto);

        }
        return response;
    }
    

    @Override
    public List<EmployeeResponseDTO> searchByName(String name) {
        // TODO
        List<Employee> list=employeeRepository.findByNameContainingIgnoreCase(name);
        List<EmployeeResponseDTO> response=new ArrayList<>();
        for(Employee emp:list){
            EmployeeResponseDTO responseDto=new EmployeeResponseDTO(
                emp.getId(),emp.getName(),emp.getJob().getId(),emp.getDateOfJoining(),
                emp.getDept().getId(),emp.getSalary()
            );
            response.add(responseDto);

        }
        return response;
    }

    @Override
    public List<EmployeeResponseDTO> getBySalaryRange(double min, double max) {
        // TODO
        List<Employee> list=employeeRepository.findBySalaryBetween(min, max);
         List<EmployeeResponseDTO> response=new ArrayList<>();
        for(Employee emp:list){
            EmployeeResponseDTO responseDto=new EmployeeResponseDTO(
                emp.getId(),emp.getName(),emp.getJob().getId(),emp.getDateOfJoining(),
                emp.getDept().getId(),emp.getSalary()
            );
            response.add(responseDto);

        }
        return response;
    }

    @Override
    public List<EmployeeResponseDTO> getByExperienceGreaterThan(int years) {
        // TODO
        LocalDate date= LocalDate.now().minusYears(years);
        List<Employee> list=employeeRepository.findByDateOfJoiningBefore(date);
         List<EmployeeResponseDTO> response=new ArrayList<>();
        for(Employee emp:list){
            EmployeeResponseDTO responseDto=new EmployeeResponseDTO(
                emp.getId(),emp.getName(),emp.getJob().getId(),emp.getDateOfJoining(),
                emp.getDept().getId(),emp.getSalary()
            );
            response.add(responseDto);

        }
        return response;
    }

    @Override
    public void updateSalary(Long empId, double salary) {
        // TODO
        Employee emp= employeeRepository.findById(empId)
        .orElseThrow(()-> new RuntimeException("Employee not found"));

        emp.setSalary(salary);
        employeeRepository.save(emp);
    }
}
