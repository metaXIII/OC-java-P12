package com.blog.mail.impl;

import com.blog.mail.dto.EmailDto;
import com.blog.mail.model.Email;
import com.blog.mail.repository.EmailRepository;
import com.blog.mail.service.IEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class EmailServiceImpl implements IEmailService {
    private final EmailRepository emailRepository;

    @Override
    public void insert(EmailDto emailDto) {
        try {
            Email email = new Email();
            email.setEmail(emailDto.getEmail());
            email.setSend(true);
            if (!this.emailCheck(email))
                throw new KeyAlreadyExistsException("L'email existe déjà");
            emailRepository.save(email);
        } catch (KeyAlreadyExistsException e) {
            log.error(e.getMessage());
        }
    }

    private boolean emailCheck(Email email) {
        Optional<Email> check = emailRepository.findByEmail(email.getEmail());
        return check.isEmpty();
    }
}
