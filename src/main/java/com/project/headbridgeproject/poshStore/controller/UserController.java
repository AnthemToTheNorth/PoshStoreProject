package com.project.headbridgeproject.poshStore.controller;

import com.project.headbridgeproject.poshStore.entity.UserEntity;
import com.project.headbridgeproject.poshStore.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity newUser) {
        return userService.create(newUser);
    }

    @PutMapping("/{id}")
    public UserEntity update(@PathVariable Long id, @RequestBody UserEntity updatedUser) {
        return userService.update(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
