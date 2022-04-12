package com.hanghae.dogfootbirdfoot_be.model;


<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
=======
import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
>>>>>>> origin/write
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
//게시물 생성이랑 동일 해야함
=======
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
>>>>>>> origin/write
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
<<<<<<< HEAD
    @Column//(name = "post_id")//변경
=======
>>>>>>> origin/write
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContents;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)//변경
    private User user;

//
//    @OneToMany(mappedBy = "post")//ㅂㅕㄴ경
//    private List<Comment> commentList;
//    = new ArrayList<Comment>();





//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User = user;

    public Post(String category, String postTitle, String postContents) {
        this.category = category;
        this.postTitle = postTitle;
        this.postContents = postContents;
        //this.nickName = nickName;
    }

//좋아요
//    @JsonIgnoreProperties({"post"})
//    @OneToMany(mappedBy = "post")
//    private List<Likes> likesList;

}
=======
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
>>>>>>> origin/write
