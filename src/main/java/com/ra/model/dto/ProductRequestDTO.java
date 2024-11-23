package com.ra.model.dto;

import com.ra.model.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequestDTO {
    private String productName;
    private Double price;
    private MultipartFile file;
    private Long categoryId;
}
