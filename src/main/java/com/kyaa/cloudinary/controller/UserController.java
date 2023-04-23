package com.kyaa.cloudinary.controller;

import com.kyaa.cloudinary.data.dto.request.RegisterUserRequest;
import com.kyaa.cloudinary.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public String registration(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam("file") MultipartFile file) throws IOException {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(name,password,file);
       return userService.register(registerUserRequest);
    }
}
