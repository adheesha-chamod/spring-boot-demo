package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
    @GetMapping("/get-user")
    public String getUser() {
        return "Get user";
    }

    @PostMapping("/add-user")
    public String addUser() {
        return "Add new user";
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
