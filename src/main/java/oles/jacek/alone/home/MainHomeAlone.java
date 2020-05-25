package oles.jacek.alone.home;

import oles.jacek.alone.home.exceptions.AnotherKevinFoundException;
import oles.jacek.alone.home.exceptions.BadCharacterFoundException;
import oles.jacek.alone.home.exceptions.NoKevinFoundException;
import oles.jacek.main.FIOutputPrinter;

import java.util.Arrays;
import java.util.HashSet;

public class MainHomeAlone {
    public static final char kevinCharacter = 'K';
    public static final char wall = '#';
    public static final char thief = 'o';
    public static final char freeSpace = ' ';

    public static void main(String[] home) {
        FIOutputPrinter fiOutputPrinter = () -> getOutput(home);
        fiOutputPrinter.printOutput(MainHomeAlone.class);
    }

    public static String getOutput(String[] home) {
        return String.format("isAlone: %b",
                isAlone(
                        Arrays.stream(home)
                                .map(String::toCharArray)
                                .toArray(char[][]::new)
                )
        );
    }

    public static boolean isAlone(char[][] tiles) {
        Coordinate kevinCoordinate = findKevinCoordinate(tiles);
        return searchThroughWholeKevinHouse(tiles, kevinCoordinate);
    }

    private static Coordinate findKevinCoordinate(char[][] tiles) {
        for (int y = 0; y < tiles.length; y++)
            for (int x = 0; x < tiles[y].length; x++)
                if (tiles[y][x] == kevinCharacter) return new Coordinate(x, y);
        throw new NoKevinFoundException();
    }

    private static boolean searchThroughWholeKevinHouse(char[][] tiles, Coordinate kevinCoordinate) {
        HashSet<Coordinate> checkedTiles = new HashSet<>();
        checkedTiles.add(kevinCoordinate);
        return checkNextConnectedTile(tiles, kevinCoordinate, checkedTiles);
    }

    private static boolean checkNextConnectedTile(char[][] tiles, Coordinate currentCoordinate, HashSet<Coordinate> checkedTiles) {
        // should not evaluate every statement
        // should stop at first false
        return checkNeighbour(tiles, new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY() - 1), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY() - 1), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY()), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY()), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY() + 1), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1), checkedTiles) &&
                checkNeighbour(tiles, new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY() + 1), checkedTiles);
    }

    private static boolean checkNeighbour(char[][] tiles, Coordinate permutationCoordinate, HashSet<Coordinate> checkedTiles) {
//        return checkedTiles.contains(permutationCoordinate) ? true : checkCoordinate(tiles, permutationCoordinate, checkedTiles);
        return checkedTiles.contains(permutationCoordinate) || checkCoordinate(tiles, permutationCoordinate, checkedTiles);
    }

    private static boolean checkCoordinate(char[][] tiles, Coordinate currentCoordinate, HashSet<Coordinate> checkedTiles) {
        checkedTiles.add(currentCoordinate);
        if (!currentCoordinate.isCoordinateInside(tiles)) return true;
        char c = tiles[currentCoordinate.getY()][currentCoordinate.getX()];
        switch (c) {
            case wall:
                return true;
            case thief:
                return false;
            case kevinCharacter:
                throw new AnotherKevinFoundException();
            case freeSpace:
//                return true && checkNextConnectedTile(tiles, currentCoordinate, checkedTiles);
                return checkNextConnectedTile(tiles, currentCoordinate, checkedTiles);
            default:
                throw new BadCharacterFoundException(c);
        }
    }
}
