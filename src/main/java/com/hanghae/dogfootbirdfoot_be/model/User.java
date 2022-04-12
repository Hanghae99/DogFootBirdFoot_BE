//package com.hanghae.dogfootbirdfoot_be.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")//이름 추가
//    private Long userId;
//
//    @Column(nullable = false)
//    private String username;
//
//    @Column(nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String nickname;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(nullable = false)
//    private String userProfile;
//
//    @OneToMany(mappedBy = "user")//변경
//    private List<Post> postList;
//
//
//
//}