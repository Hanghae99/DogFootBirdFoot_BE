package com.hanghae.dogfootbirdfoot_be.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContents;

    @Column(nullable = false)
    private String nickName;

//
//    @OneToMany(mappedBy = "comment")
//    private List<Comment> commentList = new ArrayList<Comment>();
////
//    @ManyToOne
//    @JoinColumn(name = "User_Id", nullable = false)
//    private User = user;
//
    public Post(String category, String postTitle, String postContents, String nickName) {
        this.category = category;
        this.postTitle = postTitle;
        this.postContents = postContents;
        this.nickName = nickName;
    }

//좋아요
//    @JsonIgnoreProperties({"post"})
//    @OneToMany(mappedBy = "post")
//    private List<Likes> likesList;

    }
//manytoone
//USER??
    //comment??//onetomany



