package com.web.dto;

import com.web.models.Articles;
import lombok.Data;

import java.util.List;

@Data
public class NewsDto {
    private List<Articles> articles;
}