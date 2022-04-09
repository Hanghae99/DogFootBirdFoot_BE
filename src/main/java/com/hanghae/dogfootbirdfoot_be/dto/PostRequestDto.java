package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostRequestDto {
    private String category;
    private String postTitle;
    private String postContents;
    private String nickname;
}
