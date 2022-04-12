package com.hanghae.dogfootbirdfoot_be.validator;

import org.springframework.stereotype.Component;

@Component
public class ServiceValidator {
    public static void validateSearch(String category,String searchWord){
        if(category.isEmpty()||category.equals(null)){
            throw new IllegalArgumentException("카테고리를 정해주세요.");
        }

        if(searchWord.isEmpty()||searchWord.equals(null)){
            throw new IllegalArgumentException("검색어를 입력해주세요.");
        }

    }

    public static void validatePost(String category) {
        if(category.isEmpty()||category.equals(null)){
            throw new IllegalArgumentException("카테고리를 정해주세요.");
        }
    }

}
