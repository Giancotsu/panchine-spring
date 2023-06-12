package com.giancotsu.panchine.dto;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
public class UserDTO {

    @Length(min = 5, max = 20, message = "min = 5, max = 20")
    private String username;

    @Length(min = 5, max = 20, message = "min = 5, max = 20")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
