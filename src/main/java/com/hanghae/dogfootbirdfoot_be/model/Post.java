package com.hanghae.dogfootbirdfoot_be.model;


import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContents;

    @Column(nullable = true)
    private String imageUrl;

//
//    @OneToMany(mappedBy = "comment")
//    private List<Comment> commentList = new ArrayList<Comment>();

//    @ManyToOne
//    private User user;

//
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @OneToMany
//    private List<Comment> commentList ;

//    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
//    private List<Comment> commentList;

    public Post (PostRequestDto postRequestDto){
        this.category = postRequestDto.getCategory();
        this.postTitle = postRequestDto.getPostTitle();
        this.postContents = postRequestDto.getPostContents();
        this.imageUrl = postRequestDto.getImageUrl();
    }
    public Post(String category, String postTitle, String postContents) {
        this.category = category;
        this.postTitle = postTitle;
        this.postContents = postContents;
        //this.nickName = nickName;
    }

    public Post (PostRequestDto postRequestDto, User user){
        this.category = postRequestDto.getCategory();
        this.postTitle = postRequestDto.getPostTitle();
        this.postContents = postRequestDto.getPostContents();
        this.imageUrl = postRequestDto.getImageUrl();
        this.user = user;
    }
}
