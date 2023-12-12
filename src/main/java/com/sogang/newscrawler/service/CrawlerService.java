package com.sogang.newscrawler.service;

import com.sogang.newscrawler.utils.Crawler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrawlerService {
    private final Crawler crawler;
    private final String url = "https://news.google.com/search?q=";
    public List<String> searchGoogle(String query){
        List<String> articleLinks = crawler.crawlingLinksOfPage(url + query, "a", "href");
        return articleLinks.stream().filter(Objects::nonNull).filter(it -> it.contains("articles")).collect(Collectors.toList());
    }
}
