package com.ra.model.dto;

import com.ra.model.entity.Role;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {
    private String userName;
    private String token;
    private String typeToken;
    private Set<Role> roles;
}
