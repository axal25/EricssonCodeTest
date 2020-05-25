package oles.jacek.remote.tv.exceptions;

public class BadTextContentsException extends IllegalArgumentException {
    public static final String MESSAGE = "Single string must be composed with characters available on keyboard.";

    public BadTextContentsException() {
        this(null);
    }

    public BadTextContentsException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
