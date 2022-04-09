package com.hanghae.dogfootbirdfoot_be;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DogFootBirdFoot_BE {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.properties,"
            + "classpath:aws.yml";

    public static void main(String[] args){
        new SpringApplicationBuilder(DogFootBirdFoot_BE.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}
