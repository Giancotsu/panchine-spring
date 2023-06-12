package com.giancotsu.panchine.repository;

import lombok.extern.java.Log;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Log
@Repository
public class UserRepository {
/*
    public UserDetails findUserByUsername(String username){
        if(username.equals("giancotsu")){
            log.info(username + " trovato");
            return new User("giancotsu", new BCryptPasswordEncoder().encode("pass"), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }else{
            log.warning(username + "non trovato");
            throw new UsernameNotFoundException("No User Found");
        }

    }
    
 */

}
