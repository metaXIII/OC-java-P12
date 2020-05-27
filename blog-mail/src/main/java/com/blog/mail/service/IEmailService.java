package com.blog.mail.service;

import com.blog.mail.dto.ArticleDto;
import com.blog.mail.dto.EmailDto;

import javax.mail.MessagingException;

public interface IEmailService {
    void insert(EmailDto emailDto);

    void sendEmail(ArticleDto articleDto);
}
