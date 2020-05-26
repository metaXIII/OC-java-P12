package com.blog.user.controller;

import com.blog.user.dto.PasswordDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;
import com.blog.user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("login")
    public ResponseEntity login() {
        return new ResponseEntity(SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                                  HttpStatus.ACCEPTED);
    }

    @PutMapping("updatePassword")
    public ResponseEntity updatePassword(@RequestBody PasswordDto passwordDto) throws UserNotFoundException,
            PasswordMatchException {
        try {
            userService.updatePassword(passwordDto);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
