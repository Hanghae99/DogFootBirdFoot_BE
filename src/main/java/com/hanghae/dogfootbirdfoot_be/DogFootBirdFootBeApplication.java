package com.hanghae.dogfootbirdfoot_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class DogFootBirdFootBeApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DogFootBirdFootBeApplication.class, args);
//    }
public static void main(String[] args){
    new SpringApplicationBuilder(DogFootBirdFootBeApplication.class)
            .properties(APPLICATION_LOCATIONS)
            .run(args);
}
    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.properties,"
            + "classpath:aws.yml";

    //타임 스탬프 때문에 추가
    @PostConstruct
    public void started() { System.setProperty("user.timezone", "Asia/Seoul");
        TimeZone tz = TimeZone.getTimeZone("Asia/Seoul"); TimeZone.setDefault(tz);
        System.out.println("현재시각:" + new Date());
        System.out.println(
                ZonedDateTime.now(ZoneId.of("Asia/Seoul"))); }

}
