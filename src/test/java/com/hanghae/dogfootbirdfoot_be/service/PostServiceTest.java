package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    PostRepository postRepository;

    private Long id1 = 1L;
    private String category1 = "C";
    private String postTitle1 = "제목1";
    private String postContents1 = "내용1";
    private String nickName1 = "닉네임1";

    private Long id2 = 2L;
    private String category2 = "JS";
    private String postTitle2 = "제목2";
    private String postContents2 = "내용2";
    private String nickName2 = "닉네임2";

    private Long id3 = 3L;
    private String category3 = "JS";
    private String postTitle3 = "제목3";
    private String postContents3 = "내용3";
    private String nickName3 = "닉네임3";

    Post post1 = new Post(category1,postTitle1,postContents1,nickName1);
    Post post2 = new Post(category2,postTitle2,postContents2,nickName2);
    Post post3 = new Post(category3,postTitle3,postContents3,nickName3);

    List<Post> postList = new ArrayList<>();


    @Test
    @DisplayName("정상 케이스")
    void createProduct_Normal() {
            //given
            String category = "JS";
            postList.add(post2);
            postList.add(post3);

            //when
            PostService postService = new PostService(postRepository);
            when(postRepository.findByCategoryOrderByModifiedAtDesc(category))
                    .thenReturn(postList);
            List<PostDto> results = postService.getPost(category);

            //then
        for(PostDto result:results){
            System.out.println(result.getPostTitle());
            assertEquals(result.getCategory(),"JS");
        }
    }

    @Test
    @DisplayName("실패 케이스")
    void createProduct_fail() {
        //given
        String category = "";
        //when
        PostService postService = new PostService(postRepository);

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
            postService.getPost(category);
        });
        //then
        System.out.println( exception.getMessage());
        assertEquals(
                "카테고리를 정해주세요.",
                exception.getMessage()
        );
    }


}
