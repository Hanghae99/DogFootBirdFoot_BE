package com.hanghae.dogfootbirdfoot_be.validator;

import com.hanghae.dogfootbirdfoot_be.model.Comment;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.HashMap;
import java.util.Optional;

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

    // 22.04.13
    // comment 타입 save 확인 hashmap 반환
    public static HashMap<String,String> OptionalSaveChk(Comment comment){
        HashMap<String,String> hashMap = new HashMap<>();
        if(comment != null){
            hashMap.put("result", "true");
            hashMap.put("msg", "성공적으로 저장되었습니다.");
            return hashMap;
        }else{
            hashMap.put("result", "false");
            hashMap.put("msg", "저장에 실패하였습니다.");
            return hashMap;
        }
    }

    // 22.04.14
    // 게시글 삭제, 권한 체크
    public static HashMap<String,String> postDeleteAuthChk(Long writeUser, Long loginUser){
        HashMap<String,String> hashMap = new HashMap<>();
        if(writeUser.equals(loginUser)){
            hashMap.put("result", "true");
            hashMap.put("msg", "성공적으로 게시글이 삭제되었습니다.");
            return hashMap;
        }else{
            hashMap.put("result", "false");
            hashMap.put("msg", "삭제권한이 없습니다.");
            return hashMap;
        }
    }
    

}