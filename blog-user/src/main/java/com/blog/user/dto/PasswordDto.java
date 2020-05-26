package com.blog.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {
    private String oldPassword;
    private String password;
    private String newPassword;
    private String username;
}
