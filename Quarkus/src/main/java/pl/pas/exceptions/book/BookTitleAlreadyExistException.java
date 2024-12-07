package pl.pas.exceptions.book;

import pl.pas.utils.consts.I18n;

public class BookTitleAlreadyExistException extends BookBaseException {

    public BookTitleAlreadyExistException(String message) {
        super(message);
    }
    public BookTitleAlreadyExistException() {
        super(I18n.BOOK_TITLE_ALREADY_EXIST_EXCEPTION);
    }
    public BookTitleAlreadyExistException(Throwable cause) {
        super(I18n.BOOK_TITLE_ALREADY_EXIST_EXCEPTION, cause);
    }
    public BookTitleAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
