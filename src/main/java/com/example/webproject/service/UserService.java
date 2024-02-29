package com.example.webproject.service;

import com.example.webproject.model.UserDetails;
import org.springframework.stereotype.Service;


public interface UserService {

    public UserDetails createUser(UserDetails user);
}
