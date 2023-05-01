package com.web.service;

import com.google.common.collect.ImmutableList;
import com.web.models.Articles;
import com.web.models.News;
import com.web.repository.NewsRepo;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Component
public class NewsService {
    private final NewsRepo newsRepo;
    private final Client client;

    public NewsService(NewsRepo newsRepo, Client client) {
        this.newsRepo = newsRepo;
        this.client = client;
    }

    public List<News> findAll() {
        return client.getNews().stream()
                .map(this::addNews)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private News addNews(@NonNull Articles input){
        return new News(
                input.getSource().getId(),
                input.getTitle(),
                input.getDescription(),
                input.getAuthor(),
                input.getUrl(),
                input.getPublishedAt());
    }
}
