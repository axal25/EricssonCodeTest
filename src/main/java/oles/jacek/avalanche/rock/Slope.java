package oles.jacek.avalanche.rock;

import oles.jacek.avalanche.rock.exceptions.MovableRockAtCoordinateNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Slope {
    private Map<Coordinate, ITile> grid, movableRocksToSimulate;
    private int[] fallenRocks;

    public Slope(ITile[][] tiles) {
        grid = new HashMap<>();
        movableRocksToSimulate = new HashMap<>();
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                grid.put(coordinate, tiles[y][x]);
                if (y == 0 && tiles[y][x] == Tile.ROCK.MOVABLE)
                    movableRocksToSimulate.put(coordinate, tiles[y][x]);
            }
        }
        fallenRocks = new int[tiles[0].length];
        initFallenRocks();
    }

    private void initFallenRocks() {
        while (!movableRocksToSimulate.isEmpty()) {
            Set<Coordinate> copyOfMovableRockCoordinatesToSimulate = new HashSet<>(movableRocksToSimulate.keySet());
            copyOfMovableRockCoordinatesToSimulate.stream()
                    .forEach(this::tryMovingRockFall);
        }
    }

    private boolean tryMovingRockFall(Coordinate rockOriginalCoordinate) {
        optionalVerifyRock(rockOriginalCoordinate);
        Coordinate rockPrevCoordinate = rockOriginalCoordinate;
        Coordinate rockNextCoordinate = new Coordinate(rockOriginalCoordinate.getX(), rockOriginalCoordinate.getY() + 1);
        ITile rockNextTile = null;
        while (
                rockNextCoordinate != null &&
                        grid.containsKey(rockNextCoordinate) &&
                        (rockNextTile = grid.get(rockNextCoordinate)) != Tile.ROCK.MOVABLE &&
                        rockNextTile != Tile.ROCK.STATIONARY
        ) {
            rockNextCoordinate = rockNextTile.getRocksNewCoordinate(rockNextCoordinate);
            rockPrevCoordinate = rockNextCoordinate;
        }
        if (rockNextTile == Tile.ROCK.MOVABLE) return notMoveRock();
        if (rockNextTile == Tile.ROCK.STATIONARY) return moveRock(rockOriginalCoordinate, rockPrevCoordinate);
        if (!grid.containsKey(rockNextCoordinate))
            return fallRock(rockOriginalCoordinate, rockPrevCoordinate);
        throw new UnsupportedOperationException("Something went wrong");
    }

    private void optionalVerifyRock(Coordinate rockCoordinate) {
        if (!grid.containsKey(rockCoordinate)) throw new MovableRockAtCoordinateNotFoundException(rockCoordinate, null);
        ITile supposedRock = grid.get(rockCoordinate);
        if (supposedRock != Tile.ROCK.MOVABLE)
            throw new MovableRockAtCoordinateNotFoundException(rockCoordinate, supposedRock);
    }

    private boolean fallRock(Coordinate rockOriginalCoordinate, Coordinate rockPrevCoordinate) {
        grid.put(rockOriginalCoordinate, Tile.FREE);
        movableRocksToSimulate.remove(rockOriginalCoordinate);
        fallenRocks[rockPrevCoordinate.getX()] += 1;
        return true;
    }

    private boolean notMoveRock() {
        return false;
    }

    private boolean moveRock(Coordinate rockOriginalCoordinate, Coordinate rockFinalCoordinate) {
        grid.put(rockOriginalCoordinate, Tile.FREE);
        grid.put(rockFinalCoordinate, Tile.ROCK.STATIONARY);
        movableRocksToSimulate.remove(rockOriginalCoordinate);
        return false;
    }

    public Map<Coordinate, ITile> getGrid() {
        return grid;
    }

    public Map<Coordinate, ITile> getMovableRocksToSimulate() {
        return movableRocksToSimulate;
    }

    public int[] getFallenRocks() {
        return fallenRocks;
    }
}
