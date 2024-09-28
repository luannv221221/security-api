package com.ra.service.auth;

import com.ra.model.dto.UserLoginDTO;
import com.ra.model.dto.UserRegisterDTO;
import com.ra.model.dto.UserRegisterResponseDTO;
import com.ra.model.dto.UserResponseDTO;

public interface AuthService {
    UserResponseDTO login(UserLoginDTO userLoginDTO);

    UserRegisterResponseDTO register(UserRegisterDTO userRegisterDTO);
}
