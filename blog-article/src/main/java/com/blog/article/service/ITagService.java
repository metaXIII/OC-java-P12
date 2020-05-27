package com.blog.article.service;

import com.blog.article.model.Tags;

import java.util.Set;

public interface ITagService {
    public Set<String> findAllTags();

    Tags save(Tags tags);
}
