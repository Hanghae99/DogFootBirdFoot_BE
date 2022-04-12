//package com.hanghae.dogfootbirdfoot_be.model;
//
//
////import com.hanghae.dogfootbirdfoot_be.dto.CommentRequestDto;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor
//@Entity
//
//public class Comment extends Timestamped {
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private Long id;
//
//    @Column(nullable = false)
//    private String comments;
//
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User userId;
//
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//
////    public void setPost(Post post) {
////        this.post = post;
////    }
//
//
//}