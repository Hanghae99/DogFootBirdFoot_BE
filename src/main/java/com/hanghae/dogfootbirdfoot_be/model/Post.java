package com.hanghae.dogfootbirdfoot_be.model;


import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

//게시물 생성이랑 동일 해야함

@Getter
@NoArgsConstructor
@Entity
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
