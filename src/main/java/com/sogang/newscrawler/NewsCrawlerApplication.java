package com.sogang.newscrawler;

import com.sogang.newscrawler.service.CrawlerService;
import com.sogang.newscrawler.utils.Crawler;
import org.openqa.selenium.WebElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

@SpringBootApplication
public class NewsCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsCrawlerApplication.class, args).getBean(CrawlerService.class).searchGoogle("테슬라");
	}
}
