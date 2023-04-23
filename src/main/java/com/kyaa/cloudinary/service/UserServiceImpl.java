package com.kyaa.cloudinary.service;

import com.kyaa.cloudinary.cloudservice.CloudinaryService;
import com.kyaa.cloudinary.data.dto.request.RegisterUserRequest;
import com.kyaa.cloudinary.data.model.User;
import com.kyaa.cloudinary.data.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final CloudinaryService cloudinaryService;
    private final UserRepo userRepo;
    @Override
    public String register(RegisterUserRequest registerUserRequest) throws IOException {
        User user = new User();
        user.setName(registerUserRequest.getName());
        user.setPassword(registerUserRequest.getPassword());
        String imageUrl = cloudinaryService.uploadImage(registerUserRequest.getMultipartFile());
        user.setImage(imageUrl);
        userRepo.save(user);
        return "Registration Successful";
    }
}
