package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.entity.UserEntity;
import com.project.headbridgeproject.poshStore.entity.UserRoleEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.UserRepository;
import com.project.headbridgeproject.poshStore.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public UserRoleService(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    public List<UserRoleEntity> getAllRoles() {
        return userRoleRepository.findAll();
    }

    public UserRoleEntity getRoleById(Long id) {
        return userRoleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));
    }

    public UserRoleEntity createRole(UserRoleEntity role) {
        return userRoleRepository.save(role);
    }

    public void deleteRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    public void setUserRole(Long userId, Long roleId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        UserRoleEntity role = userRoleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("Role not found"));
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
