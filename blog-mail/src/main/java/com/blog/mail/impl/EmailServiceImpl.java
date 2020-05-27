package com.blog.mail.impl;

import com.blog.mail.config.AppProperties;
import com.blog.mail.dto.ArticleDto;
import com.blog.mail.dto.EmailDto;
import com.blog.mail.model.Email;
import com.blog.mail.repository.EmailRepository;
import com.blog.mail.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.management.openmbean.KeyAlreadyExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private EmailRepository emailRepository;

    private final JavaMailSender mailSender;

    private final String defaultSender;

    public EmailServiceImpl(JavaMailSender mailSender, AppProperties appProperties) {
        this.mailSender = mailSender;
        this.defaultSender = appProperties.getDefaultEmailSender();
    }

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

    @Override
    public void sendEmail(ArticleDto articleDto) {
        List<Email> emailList = emailRepository.findAllBySendIsTrue();
        emailList.forEach((x) -> {
            try {
                System.setProperty("mail.mime.charset", "utf8");
                MimeMessage       message = this.mailSender.createMimeMessage();
                MimeMessageHelper helper  = new MimeMessageHelper(message, true, "ISO-8859-1");
                helper.setFrom(this.defaultSender);
                helper.setTo(x.getEmail());
                helper.setText("<h3>Bonjour ! </h3><p>Un nouvel article est paru sur le site, ça parle de "
                                       + articleDto.getTags().getTag() + " ! <br>Viens jeter un oeil si tu as le " +
                                       "temps !" +
                                       "<br><a href='http://localhost:4200' target='_blank'>Voir l'article : " + articleDto.getTitre() +
                                       " -- " + articleDto.getSynopsis() + "</a><br></p>",
                               true);
                helper.setSubject("Un nouvel article est paru sur le site !");
                this.mailSender.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }
}
