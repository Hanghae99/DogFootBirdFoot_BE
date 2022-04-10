package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.SearchRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final PostRepository postRepository;
//    public SearchService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    @Transactional
    public List<PostDto> search(SearchRequestDto searchRequestDto){
        String category = searchRequestDto.getCategory();
        String searchWord = searchRequestDto.getSearchWord();
        if(category.isEmpty()){
            throw new IllegalArgumentException("카테고리를 정해주세요.");
        }

        if(searchWord.isEmpty()){
            throw new IllegalArgumentException("검색어를 입력해주세요.");
        }

        //List<Post> results = postRepository.findByPostTitleContaining(searchWord);
        List<Post> results = postRepository.findAllSearch(searchWord);
        List<PostDto> show = new ArrayList<>();
              // DTO
        for(Post result:results){
            if(category.equals(result.getCategory())){
                PostDto postDto = new PostDto(result);
                show.add(postDto);
            }
        }
        return show;

//        List<Post> search = postRepository.findByTitleContainingAndCategory(searchWord, category);
//        return search;


        //검색어에 아무것도 없을 때 에러
        //카테고리가 경우에 없을 때 에러


        // 찾기
        //1.카테고리 전체 찾기
        //for 로?
        //2.카테고리에서 검색어 tream, contain  포함 단어 찾기
        //강의 봐보기
        //없다면 "존재X" 글 쓰기;//front 에서 가능

    }


}
