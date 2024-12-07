package pl.pas.exceptions.rent;

import pl.pas.utils.consts.I18n;

public class RentInvalidTimeException extends RentBaseException {
    public RentInvalidTimeException() {
        super(I18n.RENT_TIMES_INVALID_EXCEPTION);
    }
    public RentInvalidTimeException(String message) {}
    public RentInvalidTimeException(String message, Throwable cause) {}
    public RentInvalidTimeException(Throwable cause) {
        super(I18n.RENT_TIMES_INVALID_EXCEPTION, cause);
    }
}
