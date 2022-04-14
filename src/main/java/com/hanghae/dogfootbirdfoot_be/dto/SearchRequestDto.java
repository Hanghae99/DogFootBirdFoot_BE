package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
    private String category;
    private String searchWord;
}
