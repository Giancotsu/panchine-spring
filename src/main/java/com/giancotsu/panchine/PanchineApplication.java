package com.giancotsu.panchine;

import com.giancotsu.panchine.controller.UserController;
import com.giancotsu.panchine.dto.UserDTO;
import com.giancotsu.panchine.model.UserEntity;
import com.giancotsu.panchine.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PanchineApplication implements ApplicationRunner {

    private final UserController userController;
    private final UserService userService;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    public PanchineApplication(UserController userController, UserService userService) {
        this.userController = userController;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PanchineApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        UserEntity adminUser = new UserEntity();
        adminUser.setUsername(adminUsername);
        adminUser.setPassword(adminPassword);
        adminUser.setRole("ADMIN");

        userService.save(adminUser);
    }
}
