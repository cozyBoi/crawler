package com.sogang.newscrawler.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.time.Duration;

@Configuration
public class SeleniumConfig {
    @Bean
    WebDriver webDriver(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        return driver;
    }
}
