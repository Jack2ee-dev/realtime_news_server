package com.jack2ee.realtimenews.service.news;

import com.fasterxml.jackson.databind.JsonNode;

public interface NewsService {
    JsonNode getNews(String query);
}
