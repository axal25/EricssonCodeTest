package oles.jacek.remote.tv;

import oles.jacek.main.FIOutputPrinter;
import oles.jacek.remote.tv.exceptions.NullTextsException;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTvRemote {
    public static void main(String[] texts) {
        FIOutputPrinter fiOutputPrinter = () -> getOutput(texts);
        fiOutputPrinter.printOutput(MainTvRemote.class);
    }

    private static String getOutput(String[] texts) {
        return getOutputStream(texts).collect(Collectors.joining("\r\n"));
    }

    protected static Stream<String> getOutputStream(String[] texts) {
        if (texts == null) throw new NullTextsException();
        return StreamZipper.zip(
                IntStream.range(0, texts.length).boxed(),
                StreamZipper.zip(
                        Arrays.stream(texts),
                        TextProcessor.processTexts(texts),
                        (text, output) -> String.format("text: %s, output: %d", text, output)
                ),
                (index, formattedOutput) -> String.format("%d. %s", index, formattedOutput)
        );
    }

    public static int[] solve(String[] texts) {
        if (texts == null) throw new NullTextsException();
        int[] solvedAnswers = new int[texts.length];
        for (int i = 0; i < texts.length; i++)
            solvedAnswers[i] = solve(texts[i]);
        solvedAnswers = Arrays.stream(texts).map(MainTvRemote::solve).mapToInt(i -> i).toArray();
        return solvedAnswers;
    }

    public static int solve(String text) {
        return TextProcessor.processText(text);
    }
}
