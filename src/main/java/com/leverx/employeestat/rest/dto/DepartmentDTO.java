package com.leverx.employeestat.rest.dto;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApiModel(value = "Department", description = "Contains all information about department and its employees(ids)")
public class DepartmentDTO {

    private UUID id;

    @NotBlank
    private String name;

    private List<UUID> employeeIds;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UUID> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<UUID> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public void addEmployeeId(UUID id) {
        if (employeeIds == null) {
            employeeIds = new ArrayList<>();
        }
        employeeIds.add(id);
    }
}
