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
@Table(name = "cart_of_orders")
public class CartOfOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cartOfOrderEntity")
    public List<GoodsEntity> goods;

    @OneToMany(mappedBy = "cartOfOrderEntity")
    public List<OrderEntity> orders;

    @OneToOne
    @JoinColumn(name = "user_id")
    public UserEntity userId;

}
