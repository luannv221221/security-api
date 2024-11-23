package com.ra.service.product;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.repository.CategoryRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.file.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product create(ProductRequestDTO productRequestDTO) {

            Category category = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(() -> new NoSuchElementException("Id not"));;
        // xử lý upload file
        String linkImage = uploadService.uploadFile(productRequestDTO.getFile());
        Product product = Product.builder()
                .productName(productRequestDTO.getProductName())
                .price(productRequestDTO.getPrice())
                .image(linkImage)
                .category(category)
                .build();

        return productRepository.save(product);
    }
}
