package com.kyaa.cloudinary.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse> userException(UserException userException,
                                                     HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(userException.getMessage());
        apiResponse.setPath(httpServletRequest.getRequestURI());
        apiResponse.setSuccessful(false);
        apiResponse.setZonedDateTime(ZonedDateTime.now());
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
