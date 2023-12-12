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
    private final String url = "https://search.naver.com/search.naver?where=news&ie=utf8&sm=nws_hty&query=";
    public List<String> findNewsLinks(String query){
        List<String> articleLinks = crawler.crawlingUrl(url + query, "a", "href");
        return articleLinks.stream().filter(Objects::nonNull).filter(it -> it.contains("articles")).collect(Collectors.toList());
    }

    public List<String> findNewsTitles(String query){
        return crawler.crawlingUrl(url + query, "a", "title");

    }
}
