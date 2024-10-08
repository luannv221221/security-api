package com.ra.service.blog;

import com.ra.model.dto.BlogRequestDTO;
import com.ra.model.entity.Blog;

public interface BlogService {
    Blog create(BlogRequestDTO blog);
}
