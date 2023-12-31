package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.EmployeeDTO;
import com.example.springbootdemo.entity.Employee;
import com.example.springbootdemo.repo.EmployeeRepo;
import com.example.springbootdemo.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepo.existsById(employeeDTO.getId())) {
            return VarList.RES_DUPLICATED;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RES_SUCCESS;
        }
    }
}
