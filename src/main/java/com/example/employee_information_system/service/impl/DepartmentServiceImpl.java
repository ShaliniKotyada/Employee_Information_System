package com.example.employee_information_system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_information_system.dto.DepartmentResponseDTO;
import com.example.employee_information_system.entity.Department;
import com.example.employee_information_system.repository.DepartmentRepository;
import com.example.employee_information_system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository= departmentRepository;
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments(){
        List<Department> list=departmentRepository.findAll();
        List<DepartmentResponseDTO> response= new ArrayList<>();
        for(Department dept: list){
            DepartmentResponseDTO responseDto= new DepartmentResponseDTO(
               dept.getId() , dept.getName(), dept.getHodId().getId());
               response.add(responseDto);

        }
        return response;

    }
}
