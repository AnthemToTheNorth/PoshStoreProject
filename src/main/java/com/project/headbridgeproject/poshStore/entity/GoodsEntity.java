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
@Table(name = "product_goods")
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

    @ManyToMany(mappedBy = "goodsId")
    public List<CartOfOrderEntity> cartOfOrderEntities;
}
