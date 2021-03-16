package com.jack2ee.realtimenews.service.news;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack2ee.realtimenews.domain.news.naver.Sort;
import com.jack2ee.realtimenews.util.request.HttpMethodsUtil;
import com.jack2ee.realtimenews.util.request.UrlEncodeUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
@Service
public class NaverNewsServiceServiceImpl implements NewsService {

    private static final String SORT_PARAMS_PREFIX = "&sort=";
    private static final String DISPLAY_PARAMS_PREFIX = "&display=";

    @Value("${NAVER.URI}")
    private String uri;

    @Value("${NAVER.CLIENT_ID}")
    private String clientId;

    @Value("${NAVER.CLIENT_SECRET}")
    private String clientSecret;

    private final String sortedBy = Sort.SIMILARITY.getSortedBy();

    private final int displayCnt = 100;

    @Override
    public JsonNode getNews(String query) {
        String uri = uri(query);
        return json(get(uri, requestHeaders()));
    }


    public String uri(String query) {
        return this.uri +
            UrlEncodeUtil.encode(query) +
            SORT_PARAMS_PREFIX +
            sortedBy +
            DISPLAY_PARAMS_PREFIX +
            displayCnt;
    }

    private Map<String, String> requestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Naver-Client-Id", clientId);
        headers.put("X-Naver-Client-Secret", clientSecret);
        return headers;
    }

    private String get(String uri, Map<String, String> headers) {
        return HttpMethodsUtil.get(uri, headers);
    }

    private JsonNode json(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
