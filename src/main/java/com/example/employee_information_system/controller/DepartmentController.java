package com.example.employee_information_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_information_system.dto.DepartmentResponseDTO;
import com.example.employee_information_system.entity.Department;
import com.example.employee_information_system.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping("/department")
    public ResponseEntity<DepartmentService> getDepartmentService() {
        List<DepartmentResponseDTO> dept=departmentService.getAllDepartments();
        if(dept.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(departmentService);
    }
}
