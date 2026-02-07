package com.example.employee_information_system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.employee_information_system.dto.DepartmentResponseDTO;
import com.example.employee_information_system.entity.Department;

@Mapper(componentModel="spring")
public interface DepartmentMapper {
    
    @Mapping(source="hodId.id",target="hodId")
    DepartmentResponseDTO toDTO(Department department);

    List<DepartmentResponseDTO> toDTOList(List<Department> departments);


   


}