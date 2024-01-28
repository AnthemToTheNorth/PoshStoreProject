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

    @ManyToMany
    @JoinTable(name = "cart_of_order_goods",
            joinColumns = @JoinColumn(name = "cart_of_order_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id"))
    public List<ProductGoodsEntity> goodsId;

    @OneToMany(mappedBy = "cartOfOrderEntity")
    public List<OrderEntity> ordersId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "delivery_address_id")
    public DeliveryAddressEntity address;

    @OneToOne
    @JoinColumn(name = "user_id")
    public UserEntity userId;
}
