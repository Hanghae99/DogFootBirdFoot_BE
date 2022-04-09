package com.hanghae.dogfootbirdfoot_be;



import lombok.Builder;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test {
    @Getter
    @Setter
    @Builder
    public static class createPost{
        private Long id;
        private String category;
        private String postTitle;
        private String postContents;
        private String nickName;
    }


    private createPost post1 = createPost.builder()
            .id(1L)
            .category("JAVA")
            .postTitle("제목1")
            .postContents("내용1")
            .nickName("닉네임1")
            .build();

    private createPost post2 = createPost.builder()
            .id(2L)
            .category("JAVA")
            .postTitle("제목2")
            .postContents("내용2")
            .nickName("닉네임2")
            .build();

    private createPost post3 = createPost.builder()
            .id(3L)
            .category("JAVASCRIPT")
            .postTitle("제목3")
            .postContents("내용3")
            .nickName("닉네임3")
            .build();

    private createPost post4 = createPost.builder()
            .id(4L)
            .category("C")
            .postTitle("제목4")
            .postContents("내용4")
            .nickName("닉네임4")
            .build();




}
