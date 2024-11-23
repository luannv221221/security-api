package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 100,unique = true,nullable = false)
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "category")
    @JsonIgnore()
    private Set<Product> products;
}
