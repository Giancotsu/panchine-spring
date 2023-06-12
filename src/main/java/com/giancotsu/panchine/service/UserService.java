package com.giancotsu.panchine.service;

import com.giancotsu.panchine.model.UserEntity;
import com.giancotsu.panchine.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Log
public class UserService {

    private final IUserRepo userRepo;

    public void save(UserEntity user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    public UserDetails findByUsername(String username) {

        UserEntity user = userRepo.findByUsername(username);
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
        log.warning("UserDetails: " + userDetails.getUsername() + " " + userDetails.getPassword() + " " + userDetails.getAuthorities());

        return userDetails;
    }
}
