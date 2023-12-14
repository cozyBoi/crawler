package com.sogang.newscrawler;

import com.sogang.newscrawler.service.CrawlerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.sogang.newscrawler.repository")
public class NewsCrawlerApplication {
	public static void main(String[] args) {
		System.out.println(SpringApplication.run(NewsCrawlerApplication.class, args).getBean(CrawlerService.class).findNewsTitles("테슬라"));
	}
}
