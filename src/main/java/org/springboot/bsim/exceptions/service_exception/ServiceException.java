package org.springboot.bsim.exceptions.service_exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -3250091646802449334L;
    public ServiceException(String message){
        super(message);
    }
}
