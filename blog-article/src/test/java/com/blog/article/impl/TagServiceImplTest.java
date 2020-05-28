package com.blog.article.impl;

import com.blog.article.model.Tags;
import com.blog.article.repository.TagsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @InjectMocks
    private TagServiceImpl tagService;

    @Mock
    private TagsRepository tagsRepository;

    @Test
    void findAllTags() {
        assertDoesNotThrow(() -> tagService.findAllTags());
    }

    @Test
    void save() {
        when(tagsRepository.findAll()).thenReturn(new ArrayList<>());
        Tags tag = new Tags();
        tag.setTag("aze");
        assertDoesNotThrow(() -> tagService.save(tag));
    }
}