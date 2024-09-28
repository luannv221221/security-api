package com.ra.service.auth;

import com.ra.model.dto.UserLoginDTO;
import com.ra.model.dto.UserResponseDTO;

public interface AuthService {
    UserResponseDTO login(UserLoginDTO userLoginDTO);
}
