package com.sogang.newscrawler;

import com.sogang.newscrawler.service.CrawlerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsCrawlerApplication {

	public static void main(String[] args) {
		System.out.println(SpringApplication.run(NewsCrawlerApplication.class, args).getBean(CrawlerService.class).findNewsTitles("테슬라"));
	}
}
