package com.project.headbridgeproject.poshStore.controller;

import com.project.headbridgeproject.poshStore.entity.UserRoleEntity;
import com.project.headbridgeproject.poshStore.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public List<UserRoleEntity> getAllRoles() {
        return userRoleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public UserRoleEntity getRoleById(@PathVariable Long id) {
        return userRoleService.getRoleById(id);
    }

    @PostMapping
    public UserRoleEntity createRole(@RequestBody UserRoleEntity role) {
        return userRoleService.createRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        userRoleService.deleteRole(id);
    }

    @PutMapping("/{userId}/role/{roleId}")
    public void setUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        userRoleService.setUserRole(userId, roleId);
    }
}
