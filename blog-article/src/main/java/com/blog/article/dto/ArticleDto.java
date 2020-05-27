package com.blog.article.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
    private String titre;
    private String synopsis;
    private String tags;
    private String content;
    private String control;
}
