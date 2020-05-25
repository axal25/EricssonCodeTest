package oles.jacek.avalanche.rock;

import oles.jacek.avalanche.rock.exceptions.NullSlopeLevelsException;
import oles.jacek.main.FIOutputPrinter;
import oles.jacek.main.MainApp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainRockAvalanche {
    public static void main(String[] slopeLevels) {
        FIOutputPrinter fiOutputPrinter = () -> intArrayToOutputString(solve(slopeLevels));
        fiOutputPrinter.printOutput(MainRockAvalanche.class);
    }

    public static String intArrayToOutputString(int[] intArray) {
        return Arrays.stream(intArray).boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public static int[] solve(String[] slopeLevels) {
        if (slopeLevels == null) throw new NullSlopeLevelsException();
        Slope slope = new Slope(
                SlopeLevelsParser.parseSlopeLevels(slopeLevels)
        );
        return slope.getFallenRocks();
    }
}
