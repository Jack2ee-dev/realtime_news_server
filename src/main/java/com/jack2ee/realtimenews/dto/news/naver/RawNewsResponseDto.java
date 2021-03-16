package com.jack2ee.realtimenews.dto.news.naver;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RawNewsResponseDto {
    private final String lastBuildDate;

    private final int total;

    private final int start;

    private final int display;

    private final List<NewsResponseDto> items;

    public RawNewsResponseDto(String lastBuildDate, int total, int start, int display,
        List<NewsResponseDto> items) {
        this.lastBuildDate = lastBuildDate;
        this.total = total;
        this.start = start;
        this.display = display;
        this.items = items;
    }
}
