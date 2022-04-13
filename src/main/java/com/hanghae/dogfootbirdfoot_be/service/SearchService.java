package com.hanghae.dogfootbirdfoot_be.service;


import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.SearchRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepositroy;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import com.hanghae.dogfootbirdfoot_be.validator.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class SearchService {
    private final PostRepository postRepository;
    private final CommentRepositroy commentRepository;
//    public SearchService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    @Transactional
    public List<PostDto> search(SearchRequestDto searchRequestDto){
        String category = searchRequestDto.getCategory();
        String searchWord = searchRequestDto.getSearchWord();
        ServiceValidator.validateSearch(category,searchWord);

        //1차로 검색어 들어간 것 찾기

        List<Post> results = postRepository.findAllSearch(searchWord);
        List<PostDto> show = new ArrayList<>();

        //2차로 카테고리 동일한지 비교
        //코멘트 추가 22.4.13
        for(Post result:results){
            if(category.equals(result.getCategory())){
                List<Comment> commentNum = commentRepository.findAllByPostId(result);
                int commentCount = commentNum.size();
                PostDto postDto = new PostDto(result,commentCount);
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
