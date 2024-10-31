package com.javanaut.stockAlertObserver.service.impl;

import com.javanaut.stockAlertObserver.Entity.Product;
import com.javanaut.stockAlertObserver.Entity.User;
import com.javanaut.stockAlertObserver.dto.UserProductSubscribeDto;
import com.javanaut.stockAlertObserver.repository.UserRepository;
import com.javanaut.stockAlertObserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
