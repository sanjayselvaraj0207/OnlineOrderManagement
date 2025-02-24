package com.sony.adminportal.Controller;

import com.sony.adminportal.Exception.InvalidBrandName;
import com.sony.adminportal.Model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException
{
    @ExceptionHandler(InvalidBrandName.class)
    public ResponseEntity<?> handleInvalidBrandName(InvalidBrandName invalidBrandName)
    {
        ErrorModel errorModel = ErrorModel.builder()
                .errorCode("Invalid Brand Name")
                .errorMessage(invalidBrandName.getMessage())
                .build();
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }
}
