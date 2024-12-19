package br.ufrn.imd.learningplatform.cloud.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudStorageService {

    String uploadFile(MultipartFile file) throws IOException;
    void deleteFile(String file);

}
