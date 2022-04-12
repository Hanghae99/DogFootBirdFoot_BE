package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.PostImageRequestDto;
import com.hanghae.dogfootbirdfoot_be.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FileUploadController {

    private final S3Uploader s3Uploader;

    // 이미지 가져오기
    @PostMapping("/api/post/images")
    private PostImageRequestDto upload(@RequestPart("images") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getSize());
        System.out.println(multipartFile.getName());

        return s3Uploader.upload(multipartFile, "static");
    }
}
