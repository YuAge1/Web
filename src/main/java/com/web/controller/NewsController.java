package com.web.controller;

import com.web.models.News;
import com.web.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

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