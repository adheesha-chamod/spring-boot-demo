package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.UserDTO;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PutMapping("/update-user")
    public String updateUser() {
        return "Update user";
    }

    @DeleteMapping("/delete-user")
    public String deleteUser() {
        return "Delete user";
    }
}
