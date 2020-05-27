package com.blog.user.service;

import com.blog.user.dto.PasswordDto;
import com.blog.user.dto.ProfilDto;
import com.blog.user.dto.UserDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;
import com.blog.user.model.User;

import java.util.Set;

public interface IUserService {
    void updatePassword(PasswordDto passwordDto) throws UserNotFoundException, PasswordMatchException;

    User updateUser(UserDto userDto) throws UserNotFoundException;

    User updateProfil(ProfilDto profilDto) throws UserNotFoundException;

    Set<String> environnementForPublic();

    Set<String> socialForPublic();

    boolean exist(String name);
}
