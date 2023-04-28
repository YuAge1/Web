package com.web.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    private String id;

    private String name;

    private String title;

//    @Column(length = 10000)
    private String description;

//    @Column(length = 10000)
    private String content;

    private String author;

    private String url;

//    @Column(name = "image")
    private String urlToImage;

//    @Column(name = "date")
    private String publishedAt;
}