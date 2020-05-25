package oles.jacek.avalanche.rock;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
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
    public int compareTo(Coordinate other) {
        int result = other.y - this.y;
        if (result == 0)
            result = other.x - this.x;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Coordinate{ x: %d, y: %d }", this.x, this.y);
    }
}
