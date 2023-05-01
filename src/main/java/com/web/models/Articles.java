package com.web.models;

import lombok.Data;

@Data
public class Articles {
    private String author;
    private String title;
    private String description;
    private String url;
    private String publishedAt;
    private Source source;
}
