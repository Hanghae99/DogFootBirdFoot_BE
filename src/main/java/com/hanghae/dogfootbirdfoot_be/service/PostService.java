package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private  final PostRepository postRepository;

    public Page<Post> getMypostLists(User user) {
        return postRepository.findAllByUserOrderByCreatedAtDesc(user, PageRequest.of(0,5));
    }
}

