package com.blog.mail.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ArticleDto {
    private int id;

    private String titre;

    private String synopsis;

    private String content;

    private Tags tags;

    private LocalDate localDate;
}
