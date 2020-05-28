package com.blog.user.impl;

import com.blog.user.dto.PasswordDto;
import com.blog.user.dto.ProfilDto;
import com.blog.user.dto.UserDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;
import com.blog.user.model.User;
import com.blog.user.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private PasswordDto passwordDto;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserDto userDto;

    @Mock
    private ProfilDto profilDto;

    @Test
    void updatePasswordWithUserNotFoundException() {
        when(userRepository.findByUsername(any())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.updatePassword(passwordDto));
    }

    @Test
    void updatePasswordWithPasswordMatchesException() {
        when(passwordDto.getPassword()).thenReturn("aze2");
        when(passwordDto.getNewPassword()).thenReturn("aze");
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        assertThrows(PasswordMatchException.class, () -> userService.updatePassword(passwordDto));
    }

    @Test
    void updatePassword() {
        when(passwordDto.getPassword()).thenReturn("aze");
        when(passwordDto.getNewPassword()).thenReturn("aze");
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        assertDoesNotThrow(() -> userService.updatePassword(passwordDto));
    }

    @Test
    void updateUser() {
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        assertDoesNotThrow(() -> userService.updateUser(userDto));
    }

    @Test
    void updateProfil() {
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        assertDoesNotThrow(() -> userService.updateProfil(profilDto));
    }

    @Test
    void loadUserByUsername() {
        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        assertDoesNotThrow(() -> userService.loadUserByUsername("aze"));
    }

    @Test
    void environnementForPublic() {
        assertDoesNotThrow(() -> userService.environnementForPublic());
    }

    @Test
    void socialForPublic() {
        assertDoesNotThrow(() -> userService.socialForPublic());
    }

    @Test
    void exist() {
        assertDoesNotThrow(() -> userService.exist("aze"));
    }
}