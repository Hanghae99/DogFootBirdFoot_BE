package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.UserImageRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepositroy;
import com.hanghae.dogfootbirdfoot_be.repository.UserRepository;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CommentRepositroy commentRepositroy;
    // 회원가입
    @Transactional
    public User userSignup(SignupRequestDto signupRequestDto)   {
        String username = signupRequestDto.getUsername();
        // 비밀번호 암호화
        String passwordEncode = passwordEncoder.encode(signupRequestDto.getPassword());
        // 저장할 유저 객체 생성
        User user = new User(username,passwordEncode,signupRequestDto.getEmail(),signupRequestDto.getNickname());
        // 회원저장처리
       return userRepository.save(user);
    }
    // 아이디 중복체크
    public HashMap<String,String> userDupliChk(String username) {
        HashMap<String,String> hashMap= new HashMap<>();
        if(userRepository.findByUsername(username).isPresent()){
            hashMap.put("result","false");
            hashMap.put("msg" , "중복된 아이디 입니다.");
            return hashMap;
        }else{
            hashMap.put("result","true");
            hashMap.put("msg" , "사용가능한 아이디입니다");
            return hashMap;
        }
    }
    public HashMap<String,String> findUser(String username) {
        Optional<User> user =  userRepository.findByUsername(username);
        HashMap<String,String> hashMap = new HashMap<>();
        if(user.isPresent()){
            hashMap.put("result", "true");
            return hashMap;
        }else{
            hashMap.put("result", "false");
        }
        return hashMap;
    }


    // comment id로 userId를 가져와서 로그인한 user와 같은지 체크
    public HashMap<String,String> authChk(Long userId, Long commentId){
        HashMap<String,String> hashMap = new HashMap<>();
        Optional<Comment> comment = commentRepositroy.findById(commentId);

        if(comment.get().getUserId().getUserId() == userId){
            hashMap.put("result", "true");
            return hashMap;
        }else{
            hashMap.put("result", "false");
            return hashMap;
        }

    }


    @Transactional
    public void uploadUserImage(UserImageRequestDto userImageRequestDto, UserDetailsImpl userDetails){
        User user = userRepository.findById(userDetails.getUser().getUserId()).orElseThrow(
                ()-> new IllegalArgumentException("유저 정보가 없습니다.")
        );
        user.updateImgUrl(userImageRequestDto.getImageUrl());

    }
}
