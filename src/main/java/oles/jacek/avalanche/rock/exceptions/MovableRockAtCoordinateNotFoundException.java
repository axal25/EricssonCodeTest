package oles.jacek.avalanche.rock.exceptions;

import oles.jacek.avalanche.rock.Coordinate;
import oles.jacek.avalanche.rock.ITile;

public class MovableRockAtCoordinateNotFoundException extends RuntimeException {
    public static final String[] MESSAGE = {
            "Movable rock at coordinate: ",
            " not exists. AbsTile found at this coordinate is: ",
            "."
    };

    public MovableRockAtCoordinateNotFoundException(Coordinate coordinate, ITile absTile) {
        this(coordinate, absTile, null);
    }

    public MovableRockAtCoordinateNotFoundException(Coordinate coordinate, ITile iTile, Throwable cause) {
        super(String.format("%s%s%s%s%s", MESSAGE[0], coordinate.toString(), MESSAGE[1], iTile.toString(), MESSAGE[2]), cause);
    }
}
