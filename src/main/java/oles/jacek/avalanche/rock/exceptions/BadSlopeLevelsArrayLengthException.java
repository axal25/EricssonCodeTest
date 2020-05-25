package oles.jacek.avalanche.rock.exceptions;

public class BadSlopeLevelsArrayLengthException extends IllegalArgumentException {
    public static final int LENGTH_GREATER_THAN = 0;
    public static final int LENGTH_LESSER_THAN = 8;
    public static final String MESSAGE = String.format(
            "Slope levels (String[] argument) must be greater than %d, less than %d.",
            LENGTH_GREATER_THAN,
            LENGTH_LESSER_THAN
    );

    public BadSlopeLevelsArrayLengthException() {
        this(null);
    }

    public BadSlopeLevelsArrayLengthException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
