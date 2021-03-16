package com.jack2ee.realtimenews.dto.news.naver;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewsRequestDto {

    private final String requestQuery;


}
