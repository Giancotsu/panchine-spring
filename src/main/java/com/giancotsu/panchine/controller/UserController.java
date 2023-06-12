package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.dto.ResponseAuthDTO;
import com.giancotsu.panchine.dto.UserDTO;
import com.giancotsu.panchine.model.UserEntity;
import com.giancotsu.panchine.service.UserService;

import com.giancotsu.panchine.util.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Collections;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:4200" )
@RequiredArgsConstructor
@Log
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping(value = "/registration", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseAuthDTO> registerUser(@Valid @RequestBody UserDTO user) {
        if(user!=null){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setRole("USER");
            userService.save(userEntity);

            String token = jwtUtils.generateToken(new User(userEntity.getUsername(), userEntity.getPassword(), Collections.singleton(new SimpleGrantedAuthority(userEntity.getRole()))));
            ResponseAuthDTO response = new ResponseAuthDTO();
            response.setUsername(jwtUtils.extractUsername(token));
            response.setToken(token);
            response.setExp(jwtUtils.extractExpiration(token));
            response.setRole(userEntity.getRole());
            return ResponseEntity.status(200).body(response);
        }else{
            return ResponseEntity.status(400).body(new ResponseAuthDTO());
        }

    }
}
