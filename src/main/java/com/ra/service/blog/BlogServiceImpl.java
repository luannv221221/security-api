package com.ra.service.blog;

import com.ra.model.dto.BlogRequestDTO;
import com.ra.model.entity.Blog;
import com.ra.repository.BlogRepository;
import com.ra.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private FileService fileService;
    @Override
    public Blog create(BlogRequestDTO blogRequestDTO) {
        // goij den service uploadfile
        String img = fileService.uploadFileServer(blogRequestDTO.getImage());
        Blog blogNew = Blog.builder().title(blogRequestDTO.getTitle())
                .content(blogRequestDTO.getContent())
                .image(img)
                .build();
        return blogRepository.save(blogNew);
    }
}
