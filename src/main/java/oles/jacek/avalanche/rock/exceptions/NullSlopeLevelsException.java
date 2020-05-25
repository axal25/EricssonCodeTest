package oles.jacek.avalanche.rock.exceptions;

public class NullSlopeLevelsException extends IllegalArgumentException {
    public static final String MESSAGE = "Slope levels (String[] arguments) cannot be null.";

    public NullSlopeLevelsException() {
        this(null);
    }

    public NullSlopeLevelsException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
