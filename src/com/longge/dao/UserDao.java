package com.longge.dao;

import java.util.List;

import com.longge.domain.User;

public interface UserDao {
 public void add(User user);
 public void delete(User user);
 public void update(User user);
 public List<User> queryAll();   
 public User queryById(String username);
}
