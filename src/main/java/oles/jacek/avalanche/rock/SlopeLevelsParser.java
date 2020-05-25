package oles.jacek.avalanche.rock;

import oles.jacek.avalanche.rock.exceptions.BadSlopeLevelStringLengthException;
import oles.jacek.avalanche.rock.exceptions.BadSlopeLevelsArrayLengthException;
import oles.jacek.avalanche.rock.exceptions.MovableRockNotAtTopSlopeLevelException;
import oles.jacek.avalanche.rock.exceptions.NullSlopeLevelsException;

import java.util.Arrays;

public class SlopeLevelsParser {
    public static ITile[][] parseSlopeLevels(String[] slopeLevels) {
        verifySlopeLevels(slopeLevels);
        return getTiles(slopeLevels);
    }

    private static void verifySlopeLevels(String[] slopeLevels) {
        verifySlopeLevelsLength(slopeLevels);
        verifyEachSlopeLevelLength(slopeLevels);
        verifyMovableRocksOnlyAtTopSlopeLevel(slopeLevels);
    }

    private static void verifySlopeLevelsLength(String[] slopeLevels) {
        if (slopeLevels == null) throw new NullSlopeLevelsException();
        if (slopeLevels.length <= BadSlopeLevelsArrayLengthException.LENGTH_GREATER_THAN ||
                slopeLevels.length >= BadSlopeLevelsArrayLengthException.LENGTH_LESSER_THAN)
            throw new BadSlopeLevelsArrayLengthException();
    }

    private static void verifyEachSlopeLevelLength(String[] slopeLevels) {
        int zerothSlopeLevel = slopeLevels[0].length();
        Arrays.stream(slopeLevels)
                .skip(1)
                .filter(slopeLevel ->
                        slopeLevel.length() != zerothSlopeLevel ||
                                slopeLevel.length() <= BadSlopeLevelStringLengthException.LENGTH_GREATER_THAN ||
                                slopeLevel.length() >= BadSlopeLevelStringLengthException.LENGTH_LESSER_THAN
                )
                .findAny()
                .ifPresent(slopeLevelOfDifferentLength -> {
                    throw new BadSlopeLevelStringLengthException();
                });
    }

    private static void verifyMovableRocksOnlyAtTopSlopeLevel(String[] slopeLevels) {
        Arrays.stream(slopeLevels)
                .skip(1)
                .flatMap(slopeLevel -> Arrays.stream(
                        slopeLevel.split("")
                ))
                .filter(slopeTile -> slopeTile.charAt(0) == 'o')
                .findAny()
                .ifPresent(movableRockSlopeTile -> {
                    throw new MovableRockNotAtTopSlopeLevelException();
                });
    }

    private static ITile[][] getTiles(String[] slopeLevels) {
        return Arrays.stream(slopeLevels)
                .map(slopeLevel ->
                        Arrays.stream(
                                slopeLevel.split("")
                        ).map(slopeTile ->
                                TileFactory.getTile(
                                        slopeTile.charAt(0)
                                )
                        ).toArray(ITile[]::new)
                ).toArray(ITile[][]::new);
    }
}
