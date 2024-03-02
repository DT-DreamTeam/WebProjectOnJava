package com.example.webproject.service;

import com.example.webproject.model.UserDtls;


public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);
}
