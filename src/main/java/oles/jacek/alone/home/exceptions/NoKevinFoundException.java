package oles.jacek.alone.home.exceptions;

public class NoKevinFoundException extends UnsupportedOperationException {
    public static final String MESSAGE = "No Kevin found. There should be exactly 1 Kevin.";

    public NoKevinFoundException() {
        this(null);
    }

    public NoKevinFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
