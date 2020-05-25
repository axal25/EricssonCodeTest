package oles.jacek.avalanche.rock.exceptions;

public class MovableRockNotAtTopSlopeLevelException extends IllegalArgumentException {
    public static final String MESSAGE = "Movable rocks (char: 'o') allowed only at top slope level.";

    public MovableRockNotAtTopSlopeLevelException() {
        this(null);
    }

    public MovableRockNotAtTopSlopeLevelException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
