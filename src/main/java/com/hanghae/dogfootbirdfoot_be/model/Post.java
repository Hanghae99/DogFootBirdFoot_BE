package com.hanghae.dogfootbirdfoot_be.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
//게시물 생성이랑 동일 해야함
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column//(name = "post_id")//변경
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContents;

    @Column(nullable = true)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)//변경
    private User user;

    @OneToMany(mappedBy = "post")//ㅂㅕㄴ경
    private List<Comment> commentList;


//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User = user;

    public Post(String category, String postTitle, String postContents) {
        this.category = category;
        this.postTitle = postTitle;
        this.postContents = postContents;
        //this.nickName = nickName;
    }
    public Post (PostRequestDto postRequestDto){
        this.category = postRequestDto.getCategory();
        this.postTitle = postRequestDto.getPostTitle();
        this.postContents = postRequestDto.getPostContents();
    }

}