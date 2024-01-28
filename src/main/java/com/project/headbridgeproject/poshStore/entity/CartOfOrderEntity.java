package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class CartOfOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    public List<ProductGoods> goodsId;
    public List<Orders> ordersId;
    public Integer Quantity;

    public List<DeliveryAddressEntity> address;

    public List<Users> userId;
}
