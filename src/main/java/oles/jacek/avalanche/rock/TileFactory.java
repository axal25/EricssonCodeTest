package oles.jacek.avalanche.rock;

import oles.jacek.avalanche.rock.exceptions.BadCharacterException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TileFactory {
    // Lazy Thread Safe Singleton
    private static Map<Character, ITile> map;

    private TileFactory() {
    }

    private static Map<Character, ITile> getMap() {
        if (TileFactory.map == null)
            synchronized (TileFactory.class) {
                if (TileFactory.map == null) initImmutableMap();
            }
        ;
        return TileFactory.map;
    }

    private static void initImmutableMap() {
        Map<Character, ITile> mutableMap = new HashMap<>();
        mutableMap.put('.', Tile.FREE);
        mutableMap.put('o', Tile.ROCK.MOVABLE);
        mutableMap.put('_', Tile.ROCK.STATIONARY);
        mutableMap.put('/', Tile.SLOPE.LEFT);
        mutableMap.put('\\', Tile.SLOPE.RIGHT);

        TileFactory.map = Collections.unmodifiableMap(mutableMap);
    }

    public static ITile getTile(char c) {
        if (!TileFactory.getMap().containsKey(c)) throw new BadCharacterException();
        return TileFactory.getMap().get(c);
    }
}
