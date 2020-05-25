package oles.jacek.remote.tv.exceptions;

public class NullTextsException extends IllegalArgumentException {
    public static final String MESSAGE = "Texts (String[] arguments) cannot be null.";

    public NullTextsException() {
        this(null);
    }

    public NullTextsException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
