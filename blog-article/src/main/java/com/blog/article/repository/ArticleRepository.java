package com.blog.article.repository;

import com.blog.article.model.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {
    List<Article> findByTags_TagContaining(String tag);
}
