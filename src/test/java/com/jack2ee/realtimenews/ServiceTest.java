package com.jack2ee.realtimenews;

import com.jack2ee.realtimenews.service.news.NaverNewsServiceServiceImpl;
import com.jack2ee.realtimenews.util.request.UrlEncodeUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {

    @Autowired
    NaverNewsServiceServiceImpl naverNewsService;

    @Test
    void GET_NAVER_API_CONFIG_YML_TEST() {
        // given

        // when
        String uri = naverNewsService.getUri();

        // then
        assertEquals(uri, "https://openapi.naver.com/v1/search/news.json?query=");
    }


    @Test
    void COMPOSE_URI_TEST() {
        // given

        // when
        String composedUri = naverNewsService.uri("bitcoin");

        // then
        assertEquals(composedUri,
            "https://openapi.naver.com/v1/search/news.json?query=" + UrlEncodeUtil.encode("bitcoin")
                + "&sort=sim&display=100");
    }
}
