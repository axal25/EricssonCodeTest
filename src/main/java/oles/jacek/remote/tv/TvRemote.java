package oles.jacek.remote.tv;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TvRemote {
    // Lazy Thread Safe Singleton
    private static Map<Character, Coordinate> keyboard;

    private TvRemote() {
    }

    public static Map<Character, Coordinate> getKeyboard() {
        if (TvRemote.keyboard == null)
            synchronized (TvRemote.class) {
                if (TvRemote.keyboard == null) initImmutableMap();
            }
        ;
        return TvRemote.keyboard;
    }

    private static void initImmutableMap() {
        HashMap<Character, Coordinate> mutableMap = new HashMap<>();
        mutableMap.put('a', new Coordinate(0, 0));
        mutableMap.put('b', new Coordinate(1, 0));
        mutableMap.put('c', new Coordinate(2, 0));
        mutableMap.put('d', new Coordinate(3, 0));
        mutableMap.put('e', new Coordinate(4, 0));

        mutableMap.put('1', new Coordinate(5, 0));
        mutableMap.put('2', new Coordinate(6, 0));
        mutableMap.put('3', new Coordinate(7, 0));


        mutableMap.put('f', new Coordinate(0, 1));
        mutableMap.put('g', new Coordinate(1, 1));
        mutableMap.put('h', new Coordinate(2, 1));
        mutableMap.put('i', new Coordinate(3, 1));
        mutableMap.put('j', new Coordinate(4, 1));

        mutableMap.put('4', new Coordinate(5, 1));
        mutableMap.put('5', new Coordinate(6, 1));
        mutableMap.put('6', new Coordinate(7, 1));


        mutableMap.put('k', new Coordinate(0, 2));
        mutableMap.put('l', new Coordinate(1, 2));
        mutableMap.put('m', new Coordinate(2, 2));
        mutableMap.put('n', new Coordinate(3, 2));
        mutableMap.put('o', new Coordinate(4, 2));

        mutableMap.put('7', new Coordinate(5, 2));
        mutableMap.put('8', new Coordinate(6, 2));
        mutableMap.put('9', new Coordinate(7, 2));


        mutableMap.put('p', new Coordinate(0, 3));
        mutableMap.put('q', new Coordinate(1, 3));
        mutableMap.put('r', new Coordinate(2, 3));
        mutableMap.put('s', new Coordinate(3, 3));
        mutableMap.put('t', new Coordinate(4, 3));

        mutableMap.put('.', new Coordinate(5, 3));
        mutableMap.put('@', new Coordinate(6, 3));
        mutableMap.put('0', new Coordinate(7, 3));


        mutableMap.put('u', new Coordinate(0, 4));
        mutableMap.put('v', new Coordinate(1, 4));
        mutableMap.put('w', new Coordinate(2, 4));
        mutableMap.put('x', new Coordinate(3, 4));
        mutableMap.put('y', new Coordinate(4, 4));

        mutableMap.put('z', new Coordinate(5, 4));
        mutableMap.put('_', new Coordinate(6, 4));
        mutableMap.put('/', new Coordinate(7, 4));

        keyboard = Collections.unmodifiableMap(mutableMap);
    }
}
