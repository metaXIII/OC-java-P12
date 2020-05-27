package com.blog.user.controller;

import com.blog.user.dto.PasswordDto;
import com.blog.user.dto.ProfilDto;
import com.blog.user.dto.UserDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;
import com.blog.user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PutMapping("updateUser")
    public ResponseEntity updateUser(@RequestBody UserDto userDto) throws UserNotFoundException {
        try {
            return new ResponseEntity(userService.updateUser(userDto), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("updateProfil")
    public ResponseEntity updateProfil(@RequestBody ProfilDto profilDto) throws UserNotFoundException {
        try {
            return new ResponseEntity(userService.updateProfil(profilDto), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("environnement")
    public ResponseEntity<Set<String>> getEnvironnementForPublic() {
        return new ResponseEntity<>(userService.environnementForPublic(), HttpStatus.ACCEPTED);
    }

    @GetMapping("logout")
    public ResponseEntity logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("social")
    public ResponseEntity<Set<String>> getSocialForPublic() {
        return new ResponseEntity<>(userService.socialForPublic(), HttpStatus.ACCEPTED);
    }

    @GetMapping("exist/{name}")
    public ResponseEntity userExist(@PathVariable("name") String name) {
        return new ResponseEntity(userService.exist(name), HttpStatus.ACCEPTED);
    }
}
