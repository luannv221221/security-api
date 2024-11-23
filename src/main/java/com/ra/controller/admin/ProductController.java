package com.ra.controller.admin;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute ProductRequestDTO productRequestDTO){
        return new ResponseEntity<>(productService.create(productRequestDTO), HttpStatus.CREATED);
    }

}
