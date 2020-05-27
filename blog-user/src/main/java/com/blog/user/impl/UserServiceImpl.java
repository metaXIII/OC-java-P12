package com.blog.user.impl;

import com.blog.user.dto.PasswordDto;
import com.blog.user.dto.ProfilDto;
import com.blog.user.dto.UserDto;
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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
    public User updateUser(UserDto userDto) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getControl());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (userDto.getUsername() != null && !userDto.getUsername().isEmpty())
                user.setUsername(userDto.getUsername());
            if (userDto.getUsernamePublic() != null && !userDto.getUsernamePublic().isEmpty())
                user.setUsernamePublic(userDto.getUsernamePublic());
            if (userDto.getGithub() != null && !userDto.getGithub().isEmpty())
                user.setGithub(userDto.getGithub());
            if (userDto.getLinkedin() != null && !userDto.getLinkedin().isEmpty())
                user.setLinkedin(userDto.getLinkedin());
            if (userDto.getTwitter() != null && !userDto.getTwitter().isEmpty())
                user.setTwitter(userDto.getTwitter());
            if (userDto.getEmail() != null && !userDto.getEmail().isEmpty())
                user.setEmail(userDto.getEmail());
            userRepository.save(user);
            return user;
        } else
            throw new UserNotFoundException("L'utilisateur n'existe pas dans la base de donnée");
    }

    @Override
    public User updateProfil(ProfilDto profilDto) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(profilDto.getControl());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (profilDto.getAbout() != null && !profilDto.getAbout().isEmpty())
                user.setAbout(profilDto.getAbout());
            if (profilDto.getEnvironnement() != null && !profilDto.getEnvironnement().isEmpty())
                user.setEnvironnement(profilDto.getEnvironnement());
            userRepository.save(user);
            return user;
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

    @Override
    public Set<String> environnementForPublic() {
        Set<String>    collection = new HashSet<>();
        Optional<User> user       = userRepository.findById((long) 1);
        if (user.isPresent()) {
            collection.add(user.get().getEnvironnement());
            collection.add(user.get().getAbout());
        }
        return collection;
    }

    @Override
    public Set<String> socialForPublic() {
        Set<String>    collection = new HashSet<>();
        Optional<User> user       = userRepository.findById((long) 1);
        if (user.isPresent()) {
            collection.add("Github," + user.get().getGithub());
            collection.add("Linkedin," + user.get().getLinkedin());
            collection.add("Twitter," + user.get().getTwitter());
        }
        return collection;
    }
}
