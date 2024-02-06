package com.project.headbridgeproject.poshStore.repository;

import com.project.headbridgeproject.poshStore.entity.OrderEntity;
import com.project.headbridgeproject.poshStore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderEntity, Long> {


}
