package com.ra.service.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadService {
    @Value("${upload-path}")
    private String uploadPath;
    @Value("${server.port}")
    private int port;
    public String uploadFile(MultipartFile file){
        File myFile = new File(uploadPath);
        if(!myFile.exists()){
            myFile.mkdir();
        }
        String fileName = file.getOriginalFilename();

        try {
            FileCopyUtils.copy(file.getBytes(),new File(uploadPath+File.separator+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "http:localhost:"+port+"/"+fileName;
    }
}
