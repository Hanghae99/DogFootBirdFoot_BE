package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.UserInfoDto;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.repository.UserRepository;
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

    public UserInfoDto  findUser(String name) {
        Optional<User> user = userRepository.findByUsername(name);

        UserInfoDto userInfoDto = new UserInfoDto(user.get().getUsername(),user.get().getEmail(),user.get().getNickname());

        return userInfoDto;
    }

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
    public HashMap userDupliChk(String username) {
        HashMap<String,String> hashMap= new HashMap<>();
        if(userRepository.findByUsername(username).isPresent()){
            hashMap.put("result","false");
            return hashMap;
        }else{
            hashMap.put("result","true");
            return hashMap;
        }
    }
}
