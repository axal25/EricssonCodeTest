package oles.jacek.avalanche.rock.exceptions;

public class BadCharacterException extends IllegalArgumentException {
    public static final String MESSAGE = "Bad character found.";

    public BadCharacterException() {
        this(null);
    }

    public BadCharacterException(Throwable cause) {
        super(MESSAGE, cause);
    }
}