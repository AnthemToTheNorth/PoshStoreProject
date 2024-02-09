package com.project.headbridgeproject.poshStore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CartOfOrderDto {
    private Long id;
    private List<GoodsDto> goods;
    private List<OrderDto> orders;
    private UserDto userId;
}
