package com.javanaut.stockAlertObserver.service.impl;

import com.javanaut.stockAlertObserver.Entity.Product;
import com.javanaut.stockAlertObserver.Entity.User;
import com.javanaut.stockAlertObserver.dto.ProductStockUpdateDto;
import com.javanaut.stockAlertObserver.dto.UserProductSubscribeDto;
import com.javanaut.stockAlertObserver.exception.ProductNotFoundException;
import com.javanaut.stockAlertObserver.exception.UserNotFoundException;
import com.javanaut.stockAlertObserver.repository.ProductRepository;
import com.javanaut.stockAlertObserver.repository.UserRepository;
import com.javanaut.stockAlertObserver.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void subscribeProduct(UserProductSubscribeDto dto) {
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(() -> new ProductNotFoundException("Product with id : " + dto.getProductId() + "not found"));
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new UserNotFoundException("User with id : "+ dto.getUserId() + " not found"));
        product.subscribe(user);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateStock(ProductStockUpdateDto productStockUpdateDto) {
        Product product = productRepository.findById(productStockUpdateDto.getProductId()).orElseThrow(() -> new ProductNotFoundException("Product with id : "+ productStockUpdateDto.getProductId()+ " is not found"));
        boolean shouldNotify = (!Boolean.TRUE.equals(product.getIsAvailable())) && Boolean.TRUE.equals(productStockUpdateDto.getIsAvailable());
        product.setIsAvailable(productStockUpdateDto.getIsAvailable());
        product.setStock(productStockUpdateDto.getStock());
        Product savedProduct = productRepository.save(product);
        if(shouldNotify){
            product.notifyObserver();
        }
        return savedProduct;
    }
}
