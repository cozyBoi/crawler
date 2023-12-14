package com.sogang.newscrawler.repository;

import com.sogang.newscrawler.domain.NewsData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CrawlerRepository extends MongoRepository<NewsData, String> {
}
