package oles.jacek.avalanche.rock.exceptions;

public class BadSlopeLevelStringLengthException extends IllegalArgumentException {
    public static final int LENGTH_GREATER_THAN = 0;
    public static final int LENGTH_LESSER_THAN = 64;
    public static final String MESSAGE = String.format(
            "All slope levels (String[] arguments) must be of the same length, greater than %d, less than %d.",
            LENGTH_GREATER_THAN,
            LENGTH_LESSER_THAN
    );

    public BadSlopeLevelStringLengthException() {
        this(null);
    }

    public BadSlopeLevelStringLengthException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
