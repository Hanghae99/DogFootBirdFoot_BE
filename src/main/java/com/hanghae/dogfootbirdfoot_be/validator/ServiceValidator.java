package com.hanghae.dogfootbirdfoot_be.validator;

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
    // 22.4.13게시글 작성 유호성  검사 추가
    public static void validatePostWrite(String postContents){
        if (postContents.isEmpty() || postContents.equals(null)) {
            throw new IllegalArgumentException("게시글 내용을 작성해주세요.");
        }else if(postContents.length()>300){
            throw new IllegalArgumentException("300자 이내로 작성해주세요");
        }
    }

    //22.4.13 댓글작성 유효성 검사 추가
    public static void validateComment(String comment){
        if(comment.isEmpty()||comment.equals(null)){
            throw new IllegalArgumentException("댓글 내용을 작성해주세요.");
        }else if(comment.length()>300){
            throw new IllegalArgumentException("300자 이내로 작성해주세요.");
        }
    }

}