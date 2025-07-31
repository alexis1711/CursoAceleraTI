package com.enyoi.ms_orders.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String id;
    private String name;
    private Integer stock;
}
