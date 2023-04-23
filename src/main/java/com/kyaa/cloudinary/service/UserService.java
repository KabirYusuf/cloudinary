package com.kyaa.cloudinary.service;

import com.kyaa.cloudinary.data.dto.request.RegisterUserRequest;

import java.io.IOException;

public interface UserService {
    String register(RegisterUserRequest registerUserRequest) throws IOException;
}
