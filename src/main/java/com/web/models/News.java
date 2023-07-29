package com.web.models;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Getter
public class News {
    @Id
    private String id;
    private String title;
    @Column(length = 10000)
    private String description;
    private String author;
    private String url;
    @Column(name = "date")
    private String publishedAt;

    public News(String id, String title, String description, String author, String url, String publishedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.url = url;
        this.publishedAt = publishedAt;
    }

    public News() {}
}