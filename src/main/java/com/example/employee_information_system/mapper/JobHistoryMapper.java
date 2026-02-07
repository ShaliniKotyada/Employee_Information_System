package com.example.employee_information_system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

import com.example.employee_information_system.dto.JobHistoryRequestDTO;
import com.example.employee_information_system.dto.JobHistoryResponseDTO;
import com.example.employee_information_system.entity.JobHistory;

@Mapper(componentModel="spring")
public interface JobHistoryMapper {

    @Mapping(source="job.id", target="jobId")
    @Mapping(source="employee.id", target="empId")
    JobHistoryResponseDTO toDTO(JobHistory jobHistory);

    List<JobHistoryResponseDTO> toDTOList(List<JobHistory> jobHistory);
    
    // NEW METHOD (DTO -> Entity)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "job", ignore = true)
    JobHistory toEntity(JobHistoryRequestDTO dto);
    
}
