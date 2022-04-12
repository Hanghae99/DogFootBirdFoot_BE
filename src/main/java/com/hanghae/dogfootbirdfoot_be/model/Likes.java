//package com.hanghae.dogfootbirdfoot_be.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor
//@Entity
//public class Likes {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private Long postId;
//
//    @Column
//    private Long userId;
////    @JoinColumn(name = "post_id")
////    @ManyToOne
////    private Post post;
////
////    @JoinColumn(name = "user_Id")
////    @JsonIgnoreProperties({"postList"})//post, user 조인했을 때 user쪽에서 정한 이름
////    @ManyToOne
////    private User user;
////
////    @Builder
////    public Likes(Post post, User user){
////        this.post = post;
////        this.user = user;
////    }
//}
