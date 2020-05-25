package oles.jacek.alone.home.exceptions;

public class BadCharacterFoundException extends UnsupportedOperationException {
    public static final String MESSAGE = "Bad character found:";

    public BadCharacterFoundException(char c) {
        this(c, null);
    }

    public BadCharacterFoundException(char c, Throwable cause) {
        super(getMsg(c), cause);
    }

    public static String getMsg(char c) {
        return String.format("Bad character found: %c.", MESSAGE, c);
    }
}
