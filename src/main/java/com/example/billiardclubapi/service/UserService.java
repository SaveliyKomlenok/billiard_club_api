package com.example.billiardclubapi.service;

import com.example.billiardclubapi.dto.request.user.UserChangePasswordRequest;
import com.example.billiardclubapi.dto.request.user.UserRestrictRequest;
import com.example.billiardclubapi.entity.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    List<User> getAll();
    User save(User user);
    User update(User user);
    User changePassword(Long id, UserChangePasswordRequest request);
    User changeRestrictionsStatus(UserRestrictRequest request);
}
