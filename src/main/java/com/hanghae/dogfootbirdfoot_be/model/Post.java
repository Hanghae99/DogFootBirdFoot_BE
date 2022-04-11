package com.hanghae.dogfootbirdfoot_be.model;


import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Post (PostRequestDto postRequestDto){
        this.category = postRequestDto.getCategory();
        this.postTitle = postRequestDto.getPostTitle();
        this.postContents = postRequestDto.getPostContents();
    }
}
