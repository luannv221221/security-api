package com.ra.service.auth;

import com.ra.model.dto.*;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.RoleRepository;
import com.ra.repository.UserRepository;
import com.ra.security.UserPrinciple;
import com.ra.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImp implements AuthService{
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserResponseDTO login(UserLoginDTO userLoginDTO) {
        Authentication authentication;
        authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDTO.getUserName(),userLoginDTO.getPassword()));
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return UserResponseDTO.builder().
                userName(userPrinciple.getUsername()).
                token(jwtProvider.generateToken(userPrinciple)).
                typeToken("Bearer").
                roles(userPrinciple.getUser().getRoles())
                .build();
    }

    @Override
    public UserRegisterResponseDTO register(UserRegisterDTO userRegisterDTO) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findRoleByRoleName("USER");
        roles.add(role);
        User user = User.builder().
                fullName(userRegisterDTO.getFullName())
                .userName(userRegisterDTO.getUserName())
                .password(new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword())).
                status(true)
                .roles(roles)
                .build();
        User userNew = userRepository.save(user);
        return UserRegisterResponseDTO.builder().
                fullName(userNew.getFullName()).
                userName(userNew.getUserName())
                .build();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponseDTO creatAccount(AccountRequestDTO accountRequestDTO) {
        Set<Role> roles = new HashSet<>();
        for (String roleName : accountRequestDTO.getRoleName()) {
            Role role = roleRepository.findRoleByRoleName(roleName);
            roles.add(role);
        }
        User user = User.builder()
                .userName(accountRequestDTO.getUserName())
                .fullName(accountRequestDTO.getFullName())
                .password(new BCryptPasswordEncoder().encode(accountRequestDTO.getPassword()))
                .roles(roles)
                .status(true)
                .build();

        User userNew = userRepository.save(user);

        return UserResponseDTO.builder()
                .userName(userNew.getUserName())
                .roles(userNew.getRoles())
                .build();
    }
}
