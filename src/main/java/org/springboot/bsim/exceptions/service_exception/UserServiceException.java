package org.springboot.bsim.exceptions.service_exception;

public class UserServiceException extends RuntimeException{
    private static final long serialVersionUID = 3808108434933547358L;

    public UserServiceException(String message){
        super(message);
    }
}
