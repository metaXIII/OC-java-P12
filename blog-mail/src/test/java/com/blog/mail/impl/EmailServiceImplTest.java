package com.blog.mail.impl;

import com.blog.mail.config.AppProperties;
import com.blog.mail.dto.ArticleDto;
import com.blog.mail.dto.EmailDto;
import com.blog.mail.model.Email;
import com.blog.mail.repository.EmailRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmailServiceImplTest {

    @InjectMocks
    private EmailServiceImpl emailService;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private AppProperties appProperties;

    @BeforeEach
    public void init() {
        emailService = new EmailServiceImpl(javaMailSender, appProperties);
        ReflectionTestUtils.setField(emailService, "emailRepository", emailRepository);
    }

    @AfterEach
    public void end() {
        emailService = null;
    }

    @Test
    void insert() {
        EmailDto emailDto = new EmailDto();
        emailDto.setEmail("aze");
        when(emailRepository.findByEmail("aze")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> emailService.insert(emailDto));
    }

    @Test
    void sendEmail() {
        assertDoesNotThrow(() -> emailService.sendEmail(new ArticleDto()));
    }
}