package pl.pas.exceptions.user;

import pl.pas.exceptions.ApplicationBaseException;

public class UserBaseException extends ApplicationBaseException {

    public UserBaseException() {
        super();
    }
    public UserBaseException(String message) {
        super(message);
    }

    public UserBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserBaseException(Throwable cause) {
        super(cause);
    }



}

