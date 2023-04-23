package com.kyaa.cloudinary.data.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Setter
@Getter
public class RegisterUserRequest {
    private String name;
    private String password;
    private MultipartFile multipartFile;

    public RegisterUserRequest(String name, String password, MultipartFile multipartFile) {
        this.name = name;
        this.password = password;
        this.multipartFile = multipartFile;
    }
}
