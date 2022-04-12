package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

//    public Page<Comment> getMyComments(User user) {
//        return commentRepository.findAllByUserOrderByCreatedAtDesc(user, PageRequest.of(0,5));
//    }

    //페이징 있어야 되는걸까? 아마도?

}
