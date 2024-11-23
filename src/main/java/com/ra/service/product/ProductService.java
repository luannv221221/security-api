package com.ra.service.product;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product create(ProductRequestDTO productRequestDTO);

}
