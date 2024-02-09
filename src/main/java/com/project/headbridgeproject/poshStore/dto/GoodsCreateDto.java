package com.project.headbridgeproject.poshStore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GoodsCreateDto {
    private String name;
    private String description;
    private Integer price;
    private String size;
    private String brand;
    private String classification;
}

