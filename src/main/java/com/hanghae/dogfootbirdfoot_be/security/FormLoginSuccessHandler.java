package com.hanghae.dogfootbirdfoot_be.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        // Token 생성

        // 헤더에 담아 보내는 방법과 바디에 담아보내는 방법 2가지가 있음.
        final String token = JwtTokenUtils.generateJwtToken(userDetails);
        ObjectMapper objectMapper = new ObjectMapper();
//        User user = new User();
//        String User = objectMapper.writeValueAsString(user);
        // 헤더에 담음
        System.out.println(token);


        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);

//        response.getWriter().write(String.valueOf(user));
        String msg = new String (objectMapper.writeValueAsString(userDetails.getUser()).getBytes("UTF-8"), "ISO-8859-1");
        response.getOutputStream()
                .println(msg);


    }

}
