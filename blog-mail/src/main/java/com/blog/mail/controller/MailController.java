package com.blog.mail.controller;

import com.blog.mail.dto.ArticleDto;
import com.blog.mail.dto.EmailDto;
import com.blog.mail.service.IEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail/")
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class MailController {

    private final IEmailService emailService;

    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody EmailDto emailDto) {
        emailService.insert(emailDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("send")
    public ResponseEntity sendEmail(@RequestBody ArticleDto articleDto) {
        emailService.sendEmail(articleDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
