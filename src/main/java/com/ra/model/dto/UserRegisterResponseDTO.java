package com.ra.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRegisterResponseDTO {
    private String fullName;
    private String userName;
}
