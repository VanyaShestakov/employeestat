package com.leverx.employeestat.rest.service.impl;

import com.leverx.employeestat.rest.dto.EmployeeDTO;
import com.leverx.employeestat.rest.dto.converter.EmployeeConverter;
import com.leverx.employeestat.rest.repository.EmployeeRepository;
import com.leverx.employeestat.rest.repository.WorkRepository;
import com.leverx.employeestat.rest.service.AvailableEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableEmployeeServiceImpl implements AvailableEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final WorkRepository workRepository;
    private final EmployeeConverter converter;

    @Autowired
    public AvailableEmployeeServiceImpl(EmployeeRepository employeeRepository, WorkRepository workRepository, EmployeeConverter converter) {
        this.employeeRepository = employeeRepository;
        this.workRepository = workRepository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public List<EmployeeDTO> getAvailableEmployeesNow() {
        return workRepository.findAllAvailableNow()
                .stream()
                .map(work -> converter.toDTO(work.getId().getEmployee()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmployeeDTO> getAvailableEmployeesWithinMonth() {
        return workRepository.findAllAvailableWithinMonth()
                .stream()
                .map(work -> converter.toDTO(work.getId().getEmployee()))
                .collect(Collectors.toList());
    }
}