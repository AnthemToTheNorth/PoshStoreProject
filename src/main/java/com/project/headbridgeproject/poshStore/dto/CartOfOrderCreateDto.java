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
public class CartOfOrderCreateDto {
    private List<Long> goodsIds;
    private Long userId;
}
