package com.ra.model.dto;

import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountRequestDTO {
    private String fullName;
    private String userName;
    private String password;
    private Set<String> roleName;
}
