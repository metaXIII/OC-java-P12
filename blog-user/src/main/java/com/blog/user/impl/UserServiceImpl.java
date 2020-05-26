package com.blog.user.impl;

import com.blog.user.dto.PasswordDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;
import com.blog.user.model.User;
import com.blog.user.repositories.UserRepository;
import com.blog.user.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements IUserService, UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void updatePassword(PasswordDto passwordDto) throws UserNotFoundException, PasswordMatchException {
        Optional<User> user = userRepository.findByUsername(passwordDto.getUsername());
        if (user.isPresent()) {
            if (passwordDto.getPassword().equals(passwordDto.getNewPassword())) {
                user.get().setPassword(passwordEncoder.encode(passwordDto.getPassword()));
            } else
                throw new PasswordMatchException("Les mots de passe ne sont pas identiques");
        } else
            throw new UserNotFoundException("L'utilisateur n'existe pas dans la base de donnée");

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.error(String.format("user not found : %s", username));
                    return new UsernameNotFoundException("Il n'existe pas d'utilisateurs avec le nom " + "d" +
                                                                 "'utilisateur " + username);
                });
    }
}
