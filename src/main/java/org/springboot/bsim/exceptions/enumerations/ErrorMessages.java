package org.springboot.bsim.exceptions.enumerations;

public enum ErrorMessages {
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided username is not found");

    private String errorMessage;

    ErrorMessages(String errorMessage){
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     * */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     * */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
