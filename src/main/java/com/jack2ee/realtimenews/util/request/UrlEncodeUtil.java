package com.jack2ee.realtimenews.util.request;

import java.net.URLEncoder;

public class UrlEncodeUtil {

    public static String encode(String keyword) {
        try {
            return URLEncoder.encode(keyword);
        } catch (RuntimeException e) {
            throw new RuntimeException("encoding fail!", e);
        }
    }

}
