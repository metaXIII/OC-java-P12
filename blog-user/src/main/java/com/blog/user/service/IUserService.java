package com.blog.user.service;

import com.blog.user.dto.PasswordDto;
import com.blog.user.dto.ProfilDto;
import com.blog.user.dto.UserDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;
import com.blog.user.model.User;

public interface IUserService {
    void updatePassword(PasswordDto passwordDto) throws UserNotFoundException, PasswordMatchException;

    User updateUser(UserDto userDto) throws UserNotFoundException;

    User updateProfil(ProfilDto profilDto) throws UserNotFoundException;
}
