package com.giancotsu.panchine.controller;

import com.giancotsu.panchine.dto.ResponseAuthDTO;
import com.giancotsu.panchine.dto.UserDTO;
import com.giancotsu.panchine.service.UserService;
import com.giancotsu.panchine.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200" )
@Log
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping(value = "/authenticate", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseAuthDTO> authenticate(
            @RequestBody UserDTO request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        final UserDetails user = userService.findByUsername(request.getUsername());
        if(user != null){
            String token = jwtUtils.generateToken(user);
            ResponseAuthDTO response = new ResponseAuthDTO();
            response.setUsername(jwtUtils.extractUsername(token));
            response.setToken(token);
            response.setExp(jwtUtils.extractExpiration(token));
            response.setRole(jwtUtils.extractRole(token));
            return ResponseEntity.status(200).body(response);
        }
        return ResponseEntity.status(400).body(new ResponseAuthDTO());
    }


}
