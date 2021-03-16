package com.jack2ee.realtimenews.controller.news;

import com.fasterxml.jackson.databind.JsonNode;
import com.jack2ee.realtimenews.service.news.NaverNewsServiceServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/news")
@AllArgsConstructor
public class NewsController {

    private final NaverNewsServiceServiceImpl naverNewsServiceService;

    @GetMapping("/naver")
    public ResponseEntity<JsonNode> getNaverNews(@RequestParam("query") String query) {
        return new ResponseEntity<>(naverNewsServiceService.getNews(query), HttpStatus.OK);
    }
}
