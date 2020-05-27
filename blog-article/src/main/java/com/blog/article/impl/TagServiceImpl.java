package com.blog.article.impl;

import com.blog.article.model.Tags;
import com.blog.article.repository.TagsRepository;
import com.blog.article.service.ITagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl implements ITagService {

    private final TagsRepository tagsRepository;

    @Override
    public Set<String> findAllTags() {
        Set<String> tags     = new HashSet<>();
        List<Tags>  tagsList = tagsRepository.findAll();
        tagsList.forEach(x -> {
            tags.add(x.getTag());
        });
        return tags;
    }

    @Override
    public void save(Tags tagsProvided) {
        Set<String> tags     = new HashSet<>();
        List<Tags>  tagsList = tagsRepository.findAll();
        tagsList.forEach(x -> {
            tags.add(x.getTag());
        });
        if (tags.stream().noneMatch(tagsProvided.getTag()::equalsIgnoreCase))
            tagsRepository.save(tagsProvided);
    }
}
