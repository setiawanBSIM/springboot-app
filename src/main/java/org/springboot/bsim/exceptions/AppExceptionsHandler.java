package org.springboot.bsim.exceptions;

import org.springboot.bsim.exceptions.model.ErrorMessageModel;
import org.springboot.bsim.exceptions.service_exception.UserServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler {
    // Custom Exceptions
    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request){
        ErrorMessageModel errorMessageModel = new ErrorMessageModel(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessageModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Other Exceptions
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleUserServiceException(Exception ex, WebRequest request){
        ErrorMessageModel errorMessageModel = new ErrorMessageModel(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessageModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}