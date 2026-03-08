package com.arun.devtracker.controller;

import com.arun.devtracker.dto.UserDTO;
import com.arun.devtracker.entity.User;
import com.arun.devtracker.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userService::convertToDTO).toList();
    }
}