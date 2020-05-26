package com.blog.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"password", "authorities", "id"})
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String email;

    @Column(name = "USERNAMEPUBLIC")
    private String usernamePublic;

    private String password;

    private String twitter;

    private String linkedin;

    private String github;

    private String about;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
