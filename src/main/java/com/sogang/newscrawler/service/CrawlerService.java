package com.sogang.newscrawler.service;

import com.sogang.newscrawler.domain.NewsData;
import com.sogang.newscrawler.repository.CrawlerRepository;
import com.sogang.newscrawler.utils.Crawler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrawlerService {
    private final Crawler crawler;
    private final CrawlerRepository crawlerRepository;
    private final String url = "https://search.naver.com/search.naver?where=news&ie=utf8&sm=nws_hty&query=";
    public List<String> findNewsLinks(String query){
        List<String> articleLinks = crawler.crawlingUrl(url + query, "a", "href");
        return articleLinks.stream().filter(Objects::nonNull).filter(it -> it.contains("articles")).collect(Collectors.toList());
    }

    public List<String> findNewsTitles(String query){
        List<String> crawlingTitles = crawler.crawlingUrl(url + query, "a", "title");
        List<NewsData> newsDataDocuments = new ArrayList<>();
        for(String title : crawlingTitles){
            newsDataDocuments.add(NewsData.builder()
                    .title(title)
                    .build());
        }
        crawlerRepository.saveAll(newsDataDocuments);
        return crawlingTitles;
    }
}
