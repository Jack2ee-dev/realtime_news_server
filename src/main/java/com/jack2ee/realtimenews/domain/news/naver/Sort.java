package com.jack2ee.realtimenews.domain.news.naver;

import lombok.Getter;

@Getter
public enum Sort {
    SIMILARITY("sim"),
    RECENCY("date");

    private final String sortedBy;

    Sort(String sortedBy) {
        this.sortedBy = sortedBy;
    }
}
