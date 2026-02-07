package com.example.employee_information_system.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.employee_information_system.dto.EmployeeResponseDTO;
import com.example.employee_information_system.entity.Employee;

@Mapper(componentModel="spring")
public interface EmployeeMapper {

    @Mapping(source="job.id", target="jobId")
    @Mapping(source="dept.id", target="deptId")
    EmployeeResponseDTO toDTO(Employee employee);

    List<EmployeeResponseDTO> toDTOList(List<Employee> employees);
    

}
