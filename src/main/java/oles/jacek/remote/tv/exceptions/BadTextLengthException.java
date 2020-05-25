package oles.jacek.remote.tv.exceptions;

public class BadTextLengthException extends IllegalArgumentException {
    public static final String MESSAGE = "Single string must be composed of more than 0 and less than 32 characters.";

    public BadTextLengthException() {
        this(null);
    }

    public BadTextLengthException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
