package com.web.service;

import com.web.dto.NewsDto;
import com.web.models.Articles;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class Client {
    @Value("${news.api.url}")
    private String apiUrl;

    @Value("${news.api.key}")
    private String apiKey;
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<Articles> getNews() {
        String url = apiUrl + "top-headlines?country=ru&apiKey=" + apiKey;
        NewsDto response = null;
        try {
            response = restTemplate.getForObject(new URI(url), NewsDto.class);
            return response != null ? response.getArticles() : null;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}