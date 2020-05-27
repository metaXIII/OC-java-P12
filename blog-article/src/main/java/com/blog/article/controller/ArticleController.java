package com.blog.article.controller;

import com.blog.article.dto.ArticleDto;
import com.blog.article.exception.ArticleException;
import com.blog.article.model.Article;
import com.blog.article.service.IArticleService;
import com.blog.article.service.ITagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/article/")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final IArticleService articleService;

    private final ITagService tagService;

    @GetMapping("all/{page}/{number}")
    public ResponseEntity findAll(@PathVariable("page") int page, @PathVariable("number") int number) {
        List<Article> articleList = articleService.findAllForPageLimit(page - 1, number);
        return new ResponseEntity(articleList, HttpStatus.ACCEPTED);
    }

    @GetMapping("count")
    public ResponseEntity count() {
        return new ResponseEntity(articleService.findAll().size(), HttpStatus.ACCEPTED);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        try {
            return new ResponseEntity(articleService.findById(id), HttpStatus.ACCEPTED);
        } catch (Exception | ArticleException e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody ArticleDto articleDto) {
        try {
            articleService.insert(articleDto);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("tags")
    public ResponseEntity getListTags() {
        return new ResponseEntity(tagService.findAllTags(), HttpStatus.ACCEPTED);
    }
}
