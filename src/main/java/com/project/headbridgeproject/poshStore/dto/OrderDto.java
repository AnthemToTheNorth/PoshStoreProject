package com.project.headbridgeproject.poshStore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class OrderDto {
    private Long id;
    private String comments;
    private String deliveryAddresses;
    private UserDto users;
    private CartOfOrderDto cartOfOrderEntity;
}
