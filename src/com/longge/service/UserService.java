package com.longge.service;

import com.longge.domain.User;

public interface UserService {
 public boolean registerUser(User user);
 public boolean loginUser(User user);
}
