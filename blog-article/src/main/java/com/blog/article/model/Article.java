package com.blog.article.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;

    private String synopsis;

    private String content;

    private String tags;

    @Column(name = "LOCALDATE")
    private LocalDate localDate;
}
