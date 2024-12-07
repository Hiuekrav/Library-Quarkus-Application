package pl.pas.exceptions.book;

import pl.pas.utils.consts.I18n;

public class BookStatusAlreadySetException extends BookBaseException {
    public BookStatusAlreadySetException() {
        super(I18n.BOOK_STATUS_ALREADY_SET_EXCEPTION);
    }
    public BookStatusAlreadySetException(Throwable cause) {
        super(I18n.BOOK_STATUS_ALREADY_SET_EXCEPTION, cause);
    }
    public BookStatusAlreadySetException(String message) {
        super(message);
    }
    public BookStatusAlreadySetException(String message, Throwable cause) {
        super(message, cause);
    }
}
