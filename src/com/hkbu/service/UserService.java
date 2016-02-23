package com.hkbu.service;

import com.hkbu.domain.User;

public interface UserService
{
  User login(User user);

User getById(Long id);

void save(User saveUser);

void updateUser(User updateUser);
}
