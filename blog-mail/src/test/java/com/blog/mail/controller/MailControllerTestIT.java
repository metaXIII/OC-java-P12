package com.blog.mail.controller;

import com.blog.mail.dto.EmailDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Rollback
@Transactional
@AutoConfigureMockMvc
class MailControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void insert() throws Exception {
        EmailDto emailDto = new EmailDto();
        emailDto.setEmail("az2e@aze");
        this.mockMvc.perform(post("/api/mail/insert").content(asJsonString(emailDto))
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isAccepted());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}