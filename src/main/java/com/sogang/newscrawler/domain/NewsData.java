package com.sogang.newscrawler.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "newsData")
@Getter
@Builder
public class NewsData {
    @Id
    public String id;
    public String title;
}
