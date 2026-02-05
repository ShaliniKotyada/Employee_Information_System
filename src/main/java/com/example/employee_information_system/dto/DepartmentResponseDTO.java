package com.example.employee_information_system.dto;

public class DepartmentResponseDTO {
    
    private long id;
    private String name;
    private long hodId;

    public DepartmentResponseDTO(long id, String name, long hodId) {
        this.id = id;
        this.name = name;
        this.hodId = hodId;
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

    public long getHodId() {
        return hodId;
    }

    public void setHodId(long hodId) {
        this.hodId = hodId;
    }
     
}
