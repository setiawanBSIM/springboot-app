package org.springboot.bsim.exceptions;

import org.springboot.bsim.exceptions.model.ErrorMessageModel;
import org.springboot.bsim.exceptions.service_exception.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionsHandler {
    /**
     * Return Custom Error Exception (ServiceException.class)
     * */
    @ExceptionHandler(value = {ServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleUserServiceException(ServiceException ex, WebRequest request){
        ErrorMessageModel errorMessageModel = new ErrorMessageModel(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessageModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Return Other Error Exception (Exception.class)
     * */
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleOtherServiceException(Exception ex, WebRequest request){
        ErrorMessageModel errorMessageModel = new ErrorMessageModel(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorMessageModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}