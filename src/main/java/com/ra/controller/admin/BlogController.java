package com.ra.controller.admin;

import com.ra.model.dto.BlogRequestDTO;
import com.ra.model.entity.Blog;
import com.ra.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute BlogRequestDTO blogRequestDTO){
        Blog blog = blogService.create(blogRequestDTO);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
