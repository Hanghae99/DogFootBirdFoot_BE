package com.hanghae.dogfootbirdfoot_be.model;


import com.hanghae.dogfootbirdfoot_be.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String comments;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    public Comment(CommentRequestDto commentRequestDto, Post post){
        this.comments  =commentRequestDto.getComment();
        this.postId = post;
//        this.userId =
    }
    public Comment(CommentRequestDto commentRequestDto, Post post, User user){
        this.comments  =commentRequestDto.getComment();
        this.postId = post;
        this.userId = user;
//        this.userId =
    }

    // λκΈμμ 
    public void update(CommentRequestDto commentRequestDto){
        this.comments = commentRequestDto.getComment();
    }


}
