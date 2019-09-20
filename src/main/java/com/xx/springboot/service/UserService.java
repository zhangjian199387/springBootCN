package com.xx.springboot.service;

import com.xx.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
}
