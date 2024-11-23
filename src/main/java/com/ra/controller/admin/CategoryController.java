package com.ra.controller.admin;

import com.ra.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(){
        return new ResponseEntity<>("Them mơi",HttpStatus.OK);
    }
//    @PreAuthorize("hasAnyAuthority('ADMIN','SUB_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(){
        return new ResponseEntity<>("Update mơi",HttpStatus.OK);
    }
//    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(){
        return new ResponseEntity<>("xoa",HttpStatus.OK);
    }
}
