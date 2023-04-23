package com.kyaa.cloudinary.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class ApiResponse {
    private String path;
    private ZonedDateTime zonedDateTime;
    private boolean isSuccessful;
    private String data;
    private int statusCode;
}
