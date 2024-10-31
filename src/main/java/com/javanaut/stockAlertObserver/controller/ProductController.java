package com.javanaut.stockAlertObserver.controller;

import com.javanaut.stockAlertObserver.Entity.Product;
import com.javanaut.stockAlertObserver.dto.ProductStockUpdateDto;
import com.javanaut.stockAlertObserver.dto.UserProductSubscribeDto;
import com.javanaut.stockAlertObserver.service.ProductService;
import com.javanaut.stockAlertObserver.utility.StaticMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribeProduct(@RequestBody UserProductSubscribeDto dto){
        productService.subscribeProduct(dto);
        return ResponseEntity.ok(StaticMessages.SUBSCRIPTION_SUCCESS);
    }

    @PostMapping("/stock/update")
    public ResponseEntity<Product> updateStock(@RequestBody ProductStockUpdateDto productStockUpdateDto){
        Product product = productService.updateStock(productStockUpdateDto);
        return ResponseEntity.ok(product);
    }

}
