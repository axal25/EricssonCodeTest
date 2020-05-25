package oles.jacek.remote.tv;

import oles.jacek.remote.tv.exceptions.BadTextContentsException;
import oles.jacek.remote.tv.exceptions.BadTextLengthException;
import oles.jacek.remote.tv.exceptions.NullTextsException;

import java.util.Arrays;
import java.util.stream.Stream;

public class TextProcessor {
    public static Stream<Integer> processTexts(String[] texts) {
        if (texts == null) throw new NullTextsException();
        if (texts.length == 0) return Stream.empty();
        return Arrays.stream(texts).filter(text -> !text.isEmpty()).map(text -> processText(text));
    }

    public static int processText(String text) {
        verifyText(text);
        Cursor cursor = new Cursor();
        Stream.of(text.split(""))
                .map(stringChar -> stringChar.charAt(0))
                .map(TextProcessor::verifyChar)
                .forEach(cursor::moveAndSelect);
        return cursor.getClicks();
    }

    private static void verifyText(String text) {
        if (text == null || text.isEmpty() || text.length() >= 32)
            throw new BadTextLengthException();
    }

    private static char verifyChar(Character c) {
        if (!TvRemote.getKeyboard().containsKey(c))
            throw new BadTextContentsException();
        return c;
    }
}
