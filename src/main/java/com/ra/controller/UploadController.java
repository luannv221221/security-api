package com.ra.controller;

import com.ra.service.file.FileService;
import com.ra.service.file.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/")
public class UploadController {
    @Autowired
    private FileService fileService;
    @Autowired
    private UploadService uploadService;
    @PostMapping("upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile file){
//        System.out.println(file);
//        String fileUrl = fileService.uploadFileServer(file);
        String fileUrl = uploadService.uploadFile(file);
        return ResponseEntity.ok(fileUrl);
    }
}
