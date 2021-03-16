package com.jack2ee.realtimenews.domain.news.naver;

import com.jack2ee.realtimenews.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

@Getter
public class News extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String originalLink;

    @Column
    private String link;

    @Column
    private String description;

    @Column
    private String pubDate;

    public News(String title, String originalLink, String link, String description,
        String pubDate) {
        this.title = title;
        this.originalLink = originalLink;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
    }

    public News() {
    }
}
