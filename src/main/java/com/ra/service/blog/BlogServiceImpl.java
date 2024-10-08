package com.ra.service.blog;

import com.ra.model.entity.Blog;
import com.ra.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }
}
