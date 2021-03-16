package com.jack2ee.realtimenews.util.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpMethodsUtil {
    public static String get(String apiUri, Map<String, String> requestHeaders) {
        HttpURLConnection connection = connect(apiUri);
        try {
            connection.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return responseBody(connection.getInputStream());
            }
            return responseBody(connection.getErrorStream());

        } catch (ProtocolException e) {
            throw new RuntimeException("request method가 잘못 설정되었습니다.", e);

        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답에 실패하였습니다.", e);
        } finally {
            connection.disconnect();
        }

    }

    private static String responseBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);
        try {
            BufferedReader bf = new BufferedReader(streamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

    private static HttpURLConnection connect(String url) throws RuntimeException {
        try {
            URL newUrl = new URL(url);
            return (HttpURLConnection) newUrl.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL이 잘못되었습니다. 입력 URL: " + url, e);
        } catch (IOException e) {
            throw new RuntimeException("연결에 실패하였습니다.", e);
        }
    }

}
