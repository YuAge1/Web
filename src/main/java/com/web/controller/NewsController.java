package com.web.controller;

import com.web.models.News;
import com.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping("/api/news")
    public List<News> getAllNews(){
        return newsService.findAll();
    }

    @RequestMapping("/news")
    public String findLastNews(Model model){
        List<News> news = newsService.findAll();
        model.addAttribute("news", news);
        return "page-with-news";
    }
}
