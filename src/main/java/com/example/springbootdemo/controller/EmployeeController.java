package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.EmployeeDTO;
import com.example.springbootdemo.dto.ResponseDTO;
import com.example.springbootdemo.service.EmployeeService;
import com.example.springbootdemo.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/employee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String res = employeeService.saveEmployee(employeeDTO);

            if(res.equals("00")) {
                responseDTO.setCode(VarList.RES_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.CREATED);

            } else if(res.equals("06")) {
                responseDTO.setCode(VarList.RES_DUPLICATED);
                responseDTO.setMessage("Employee already exists");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.CONFLICT);

            } else {
                responseDTO.setCode(VarList.RES_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception err) {
            responseDTO.setCode(VarList.RES_ERROR);
            responseDTO.setMessage(err.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String res = employeeService.updateEmployee(employeeDTO);

            if(res.equals("00")) {
                responseDTO.setCode(VarList.RES_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.CREATED);

            } else if(res.equals("01")) {
                responseDTO.setCode(VarList.RES_DUPLICATED);
                responseDTO.setMessage("Employee not found");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            } else {
                responseDTO.setCode(VarList.RES_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception err) {
            responseDTO.setCode(VarList.RES_ERROR);
            responseDTO.setMessage(err.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee")
    public ResponseEntity getAllEmployees() {
        try {
            List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();

            responseDTO.setCode(VarList.RES_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(employeeDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.CREATED);

        } catch (Exception err) {
            responseDTO.setCode(VarList.RES_ERROR);
            responseDTO.setMessage(err.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
