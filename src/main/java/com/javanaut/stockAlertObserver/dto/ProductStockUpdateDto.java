package com.javanaut.stockAlertObserver.dto;

import lombok.Data;

@Data
public class ProductStockUpdateDto {
    private Long productId;
    private int stock;
    private Boolean isAvailable;
}
