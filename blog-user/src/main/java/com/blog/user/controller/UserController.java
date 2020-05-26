package com.blog.user.controller;

import com.blog.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("login")
    public ResponseEntity login() {
        return new ResponseEntity(SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                                  HttpStatus.ACCEPTED);
    }
}
