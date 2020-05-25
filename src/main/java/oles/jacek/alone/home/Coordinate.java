package oles.jacek.alone.home;

import java.util.Objects;

public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCoordinateInside(char[][] tiles) {
        return this.y >= 0 && this.y < tiles.length &&
                this.x >= 0 && this.x < tiles[0].length;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (!(otherObj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) otherObj;
        return this.getX() == other.getX() &&
                this.getY() == other.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return String.format("Coordinate{ x: %d, y: %d }", this.x, this.y);
    }
}

