package oles.jacek.alone.home.exceptions;

public class AnotherKevinFoundException extends UnsupportedOperationException {
    public static final String MESSAGE = "Another Kevin found. There should be only 1 Kevin.";

    public AnotherKevinFoundException() {
        this(null);
    }

    public AnotherKevinFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
