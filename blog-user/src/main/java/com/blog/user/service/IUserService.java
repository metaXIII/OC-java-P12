package com.blog.user.service;

import com.blog.user.dto.PasswordDto;
import com.blog.user.exception.PasswordMatchException;
import com.blog.user.exception.UserNotFoundException;

public interface IUserService {
    void updatePassword(PasswordDto passwordDto) throws UserNotFoundException, PasswordMatchException;
}
