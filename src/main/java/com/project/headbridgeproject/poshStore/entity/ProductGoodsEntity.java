package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ProductGoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "description", nullable = false)
    public String description;
    @Column(name = "price", nullable = false)
    public Integer price;
    @Column(name = "size", nullable = false)
    public String size;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    public ProductBrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    public ProductClassificationEntity classification;

    //public List<ProductBrandEntity> brandId;
    /*много товаров - одна классификация
    public List<ProductClassificationEntity> classificationId;*/
}
