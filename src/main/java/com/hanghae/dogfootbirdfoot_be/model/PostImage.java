package com.hanghae.dogfootbirdfoot_be.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String filePath;

    private Long filesize;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post posts;
}
