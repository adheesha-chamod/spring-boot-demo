package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.EmployeeDTO;
import com.example.springbootdemo.entity.Employee;
import com.example.springbootdemo.repo.EmployeeRepo;
import com.example.springbootdemo.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public String updateEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepo.existsById(employeeDTO.getId())) {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RES_SUCCESS;
        } else {
            return VarList.RES_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>(){}.getType());
    }
}