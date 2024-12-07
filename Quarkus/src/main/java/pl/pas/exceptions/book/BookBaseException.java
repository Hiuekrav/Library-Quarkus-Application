package pl.pas.exceptions.book;

import pl.pas.exceptions.ApplicationBaseException;

public class BookBaseException extends ApplicationBaseException {

  public BookBaseException() {
    super();
  }
  public BookBaseException(String message) {
    super(message);
  }

  public BookBaseException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookBaseException(Throwable cause) {
    super(cause);
  }
}
