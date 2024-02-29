package com.example.webproject.service;

import com.example.webproject.model.UserDetails;
import com.example.webproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails createUser(UserDetails user) {
        return userRepo.save(user);
    }
}
