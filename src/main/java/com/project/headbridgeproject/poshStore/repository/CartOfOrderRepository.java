package com.project.headbridgeproject.poshStore.repository;

import com.project.headbridgeproject.poshStore.entity.CartOfOrderEntity;
import com.project.headbridgeproject.poshStore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartOfOrderRepository extends JpaRepository<CartOfOrderEntity, Long> {
}
