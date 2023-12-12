package com.sogang.newscrawler.utils;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Crawler {
    private final WebDriver webDriver;
    public List<String> crawlingLinksOfPage(String url, String tag, String attr){
        List<WebElement> webElements = findElements(url, tag);
        return webElements.stream().map(it -> it.getAttribute(attr)).toList();
    }

    private List<WebElement> findElements(String url, String tag){
        webDriver.get(url);
        return webDriver.findElements(By.tagName(tag));
    }

    public String getPage(String url){
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return webDriver.getPageSource();
    }
}
