package com.project.headbridgeproject.poshStore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class OrderCreateDto {
    private String comments;
    private String deliveryAddresses;
    private Long userId;
    private Long cartOfOrderId;
}
