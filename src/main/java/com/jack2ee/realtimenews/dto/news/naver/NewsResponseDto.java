package com.jack2ee.realtimenews.dto.news.naver;

import java.util.List;

import lombok.Builder;

@Builder
public class NewsResponseDto {
    private final List<String> items;

    public NewsResponseDto(List<String> items) {
        this.items = items;
    }
}
