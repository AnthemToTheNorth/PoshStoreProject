package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_goods")
@Builder
public class GoodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "size", nullable = false)
    private String size;

    @Column
    private String brand;

    @Column
    private String classification;

    @ManyToOne
    @JoinColumn(name = "cart_of_order_id")
    public CartOfOrderEntity cartOfOrderEntity;

}
