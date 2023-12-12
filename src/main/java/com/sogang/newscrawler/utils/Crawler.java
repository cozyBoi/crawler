package com.sogang.newscrawler.utils;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Crawler {
    private final WebDriver webDriver;
    public List<String> crawlingUrl(String url, String tag, String attr){
        List<WebElement> webElements = findElements(url, tag);
        List<String> strings = new ArrayList<>();
        for(WebElement we : webElements){
            if(we.getAttribute(attr) == null || we.getAttribute(attr).isEmpty()) continue;
            strings.add(we.getAttribute(attr));
        }
        return strings;
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
