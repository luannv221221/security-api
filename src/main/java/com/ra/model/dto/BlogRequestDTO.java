package com.ra.model.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BlogRequestDTO {
    private String title;
    private String content;
    private MultipartFile image;
}
