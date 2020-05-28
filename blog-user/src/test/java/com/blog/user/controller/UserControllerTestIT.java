package com.blog.user.controller;

import com.blog.user.dto.PasswordDto;
import com.blog.user.dto.ProfilDto;
import com.blog.user.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Rollback
@Transactional
@AutoConfigureMockMvc
class UserControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        this.mockMvc.perform(get("/api/user/login"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void getEnvironnementForPublic() throws Exception {
        this.mockMvc.perform(get("/api/user/environnement"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void logout() throws Exception {
        this.mockMvc.perform(get("/api/user/logout"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void getSocialForPublic() throws Exception {
        this.mockMvc.perform(get("/api/user/social"))
                .andDo(print()).andExpect(status().isAccepted());
    }

    @Test
    void userExist() throws Exception {
        this.mockMvc.perform(get("/api/user/exist/{name}", ""))
                .andDo(print()).andExpect(status().isNotFound());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}