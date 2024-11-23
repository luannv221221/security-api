package com.ra.model.dto;

import com.ra.model.entity.Role;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO implements Serializable {
    private String userName;
    private String token;
    private String typeToken;
    private Set<Role> roles;
}
