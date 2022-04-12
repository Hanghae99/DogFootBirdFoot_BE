package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.SearchRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {
    @Mock
    PostRepository postRepository;

    private Long id1 = 1L;
    private String category1 = "C";
    private String postTitle1 = "제목3";
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

    private Long id4 = 4L;
    private String category4 = "JS";
    private String postTitle4 = "제목3";
    private String postContents4 = "내용4";
    private String nickName4 = "닉네임4";

    Post post1 = new Post(category1,postTitle1,postContents1);
    Post post2 = new Post(category2,postTitle2,postContents2);
    Post post3 = new Post(category3,postTitle3,postContents3);
    Post post4 = new Post(category4,postTitle4,postContents4);

    List<Post> postList = new ArrayList<>();
    List<PostDto> postDtoList = new ArrayList<>();


    @Test
    @DisplayName("정상 케이스")
    void createProduct_Normal() {
        //given
        String category = "JS";
        String searchWord = "3";
        SearchRequestDto requestDto = new SearchRequestDto(category,searchWord);
        postList.add(post1);
        postList.add(post3);
        postList.add(post4);
        int cnt = 0;

        //when
        SearchService searchService = new SearchService(postRepository);
        when(postRepository.findAllSearch(searchWord))
                .thenReturn(postList);
        List<PostDto> results = searchService.search(requestDto);

        //then
        for(PostDto result:results){
            System.out.println(result.getPostTitle());
            System.out.println(result.getCategory());
            System.out.println(result.getNickName());

            if(result.getPostTitle().contains("3")){
                cnt++;
            }
        }

        assertEquals(cnt,2);
    }

    @Test
    @DisplayName("카테고리가 안들어 왔을 때")

    void createProduct_fail_category() {
        //given
        String category = "";
        String searchWord = "제";
        SearchRequestDto requestDto = new SearchRequestDto(category,searchWord);
        //when
        SearchService searchService = new SearchService(postRepository);

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
            searchService.search(requestDto);
        });
        //then
        System.out.println( exception.getMessage());
        assertEquals(
                "카테고리를 정해주세요.",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("검색어가 안들어 왔을 때")

    void createProduct_fail_searchWord() {
        //given
        String category = "C";
        String searchWord = "";
        SearchRequestDto requestDto = new SearchRequestDto(category,searchWord);
        //when
        SearchService searchService = new SearchService(postRepository);

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
            searchService.search(requestDto);
        });
        //then
        System.out.println( exception.getMessage());
        assertEquals(
                "검색어를 입력해주세요.",
                exception.getMessage()
        );
    }



}