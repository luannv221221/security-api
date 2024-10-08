package com.ra.service.file;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class StorageConfig {
    @Bean
    public Storage storage() throws IOException {
        String uploadFirebaseConfigPath = "D:\\Luannv\\apache-tomcat-9.0.83\\PT_240416\\MD4\\session06\\src\\main\\resources\\firbaseKey.json";
        InputStream inputStream = Files.newInputStream(Paths.get(uploadFirebaseConfigPath));
        return StorageOptions.newBuilder().
                setCredentials(GoogleCredentials.fromStream(inputStream))
                .build().getService();
    }
}
