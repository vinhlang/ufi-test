package vn.vti.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

@SuppressWarnings("serial")
public class ApiException extends ResponseStatusException {

    String errorCode;

    String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ApiException(HttpStatus status, String errorCode, String errorMessage) {
        super(status);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Constructor with a response status.
     * @param status the HTTP status (required)
     */
    public ApiException(HttpStatus status) {
        super(status);
    }

    /**
     * Constructor with a response status and a reason to add to the exception message as
     * explanation.
     * @param status the HTTP status (required)
     * @param reason the associated reason (optional)
     */
    public ApiException(HttpStatus status, @Nullable String reason) {
        super(status, reason);
    }

    /**
     * Constructor with a response status and a reason to add to the exception message as
     * explanation, as well as a nested exception.
     * @param status the HTTP status (required)
     * @param reason the associated reason (optional)
     * @param cause a nested exception (optional)
     */
    public ApiException(HttpStatus status, @Nullable String reason, @Nullable Throwable cause) {
        super(status, reason, cause);
    }

}

