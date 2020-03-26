package com.haterspoint.service;

import com.haterspoint.dto.User;

public interface UserService {

    Integer signUp(User user);
    Integer logIn(User user);
}
