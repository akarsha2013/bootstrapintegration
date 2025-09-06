package com.example.jdbctemplatedemo.service;

import com.example.jdbctemplatedemo.model.User;
import com.example.jdbctemplatedemo.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@AllArgsConstructor
@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public void register(User user){
        //we call data base layer method
        registerRepository.createUser(user);
    }

}
