package com.blog.article.controller;

import com.blog.article.dto.ArticleDto;
import com.blog.article.dto.ArticleUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Rollback
@Transactional
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        this.mockMvc.perform(get("/api/article/all/{page}/{number}", 1, 20))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void count() throws Exception {
        this.mockMvc.perform(get("/api/article/count"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void getById() throws Exception {
        this.mockMvc.perform(get("/api/article/findById/{id}", 1))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void getByIdWithBadId() throws Exception {
        this.mockMvc.perform(get("/api/article/findById/{id}", 0))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void insert() throws Exception {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setContent("");
        articleDto.setControl("");
        articleDto.setSynopsis("");
        articleDto.setTags("");
        articleDto.setTitre("");
        this.mockMvc.perform(post("/api/article/insert", articleDto)
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void insertWithException() throws Exception {
        this.mockMvc.perform(post("/api/article/insert", new ArticleDto())
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void getListTags() throws Exception {
        this.mockMvc.perform(get("/api/article/tags"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void search() throws Exception {
        this.mockMvc.perform(get("/api/article/search/{category}", "Linux"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void getAllArticles() throws Exception {
        this.mockMvc.perform(get("/api/article/admin-all"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void updateArticle() throws Exception {
        this.mockMvc.perform(post("/api/article/update", new ArticleUpdateDto())
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}