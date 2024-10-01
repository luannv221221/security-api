package com.ra.service.auth;

import com.ra.model.dto.*;
import com.ra.model.entity.User;

import java.util.List;

public interface AuthService {
    UserResponseDTO login(UserLoginDTO userLoginDTO);
    UserRegisterResponseDTO register(UserRegisterDTO userRegisterDTO);
    List<User> findAll();
    UserResponseDTO creatAccount(AccountRequestDTO accountRequestDTO);
}
