package com.hanghae.dogfootbirdfoot_be.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders headers;
    private ObjectMapper mapper = new ObjectMapper();
    // 유저객체 초기화


    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Nested
    @DisplayName("회원 등록")
    class RegisterUser {
        @Test
        @Order(1)
        @DisplayName("일반 회원1 등록 ")
        void test1() throws JsonProcessingException {
            //given
            UserInfoDto user1 = UserInfoDto.builder()
                    .username("김주호1")
                    .password("123123")
                    .nickname("주호킴스")
                    .email("kim1jo2ho3@naver.com")
                    .build();
            String requestBody = mapper.writeValueAsString(user1);
            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            //when
            ResponseEntity<UserInfoDto> response = restTemplate.postForEntity(
                    "/api/user/signup",
                    request,
                    UserInfoDto.class);
            //then
            assertEquals(HttpStatus.OK, response.getStatusCode());
            UserInfoDto userDtoResponse = response.getBody();
            assertNotNull(userDtoResponse);
            assertEquals(user1.username, userDtoResponse.username);
            assertEquals(user1.nickname, userDtoResponse.nickname);
            assertEquals(user1.email,    userDtoResponse.email);

        }

        @Test
        @Order(2)
        @DisplayName("user 로그인 ")
        void test2() throws JsonProcessingException{
            //given
            UserloginDto login1 = UserloginDto.builder()
                    .username("김주호1")
                    .password("123123")

                    .build();
            String requestBody = mapper.writeValueAsString(login1);
            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            //when
            ResponseEntity<UserInfoDto> response = restTemplate.postForEntity(
                    "/user/login",
                    request,
                    UserInfoDto.class);
            //then
            System.out.println(response.getHeaders());
            System.out.println(response.getBody());
            HttpHeaders userDtoHeader = response.getHeaders();
            assertEquals(HttpStatus.OK, response.getStatusCode());
            UserInfoDto userDtoResponse = response.getBody();

        }
    }

    @Getter
    @Setter
    @Builder
    static class UserInfoDto {
        private String username;
        private String email;
        private String nickname;
        private String password;
    }
    @Getter
    @Setter
    @Builder
    static class UserloginDto {
        private String username;
        private String password;
    }


}