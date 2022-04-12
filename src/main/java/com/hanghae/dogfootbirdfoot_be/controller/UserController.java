package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.user.UserRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;
//    private final JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/api/mypage/{userId}")
//    public void getUserInfo(UserRequestDto userRequestDto){
//        userService.getUserInfo(userRequestDto);
//    }
//
//    //마이페이지.
//    @GetMapping("/api/mypage")
//    @ResponseBody
//    public LoginResDto getUserInfoFromToken(@RequestHeader(value="X-AUTH-TOKEN") String token) {
//        System.out.println("==============receieveToken==============");
//        System.out.println(token);
//        System.out.println("==============receieveToken==============");
//        jwtTokenProvider.validateToken(token);
//        return getLoginResDtoFromToken(token);
//    }

    //프로필 사진 업로드 하기.
//    @PutMapping("/api/mypage/{userId}/userProfile")
//    public Long updateProfileImg(@RequestBody User user){
//        return userService.update(user);
//    }

    //RequestBody json -> java객체로 변환.
    //ResponseBody java -> json으로 변환.


//    @PostMapping("/api/mypage/{userId}/userProfile")
//    public Map<String, Object> updateUserProfile(@PathVariable("userId") Long userId, @RequestBody MultipartFile file) {
//        ImageDto imageDto = updateProfile(file);
//        if(imageDto.getContent()==null) {
//            return imageDto.getMap();
//        }
//        userImageService.update(userService.findOneById(userId), (Image) imageDto.getContent());
//        return imageDto.getMap();
//    }

    //참고 블로그
    //https://velog.io/@yyong3519/Springboot-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%B2%98%EB%A6%AC
}
