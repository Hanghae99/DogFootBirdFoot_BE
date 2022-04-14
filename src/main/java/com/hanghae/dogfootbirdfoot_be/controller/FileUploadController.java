package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.PostImageRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.UserImageRequestDto;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.S3Uploader;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private final UserService userService;
    // 이미지 가져오기
    @PostMapping("/api/post/images")
    private PostImageRequestDto uploadPostImage(@RequestPart("images") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getSize());
        System.out.println(multipartFile.getName());
        PostImageRequestDto postImageRequestDto = new PostImageRequestDto(s3Uploader.upload(multipartFile, "static"));
        return postImageRequestDto;

    }

    @PostMapping("/api/mypage/userProfile")
    private UserImageRequestDto uploadUserImage(@RequestPart("images") MultipartFile multipartFile, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getSize());
        System.out.println(multipartFile.getName());
        UserImageRequestDto userImageRequestDto = new UserImageRequestDto(s3Uploader.upload(multipartFile, "static"));
        userService.uploadUserImage(userImageRequestDto, userDetails);
        return userImageRequestDto;
    }
}
