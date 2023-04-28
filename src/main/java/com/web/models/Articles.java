package com.web.models;

import lombok.Data;

@Data
public class Articles {
    private String author;
    private String title;
    private String content;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private Source source;
    /*@JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("urlToImage")
    private String urlToImage;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("source")
    private Source source;*/
}
