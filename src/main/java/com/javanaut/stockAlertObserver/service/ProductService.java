package com.javanaut.stockAlertObserver.service;

import com.javanaut.stockAlertObserver.Entity.Product;
import com.javanaut.stockAlertObserver.dto.ProductStockUpdateDto;
import com.javanaut.stockAlertObserver.dto.UserProductSubscribeDto;

public interface ProductService {
    Product saveProduct(Product product);

    void subscribeProduct(UserProductSubscribeDto dto);

    Product updateStock(ProductStockUpdateDto productStockUpdateDto);
}
