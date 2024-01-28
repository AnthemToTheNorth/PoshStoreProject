package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "comments", nullable = false)
    public String comments;


    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user;
    //public List<Users> userId;

    public List<DeliveryAddresses> deliveryId;




    //одна корзина - много заказов
    //много пользователей - много заказов
    // много заказов - много адресов доставки

    //public List<Users> userId;




}
