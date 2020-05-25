package oles.jacek.remote.tv;

import oles.jacek.remote.tv.exceptions.BadTextContentsException;
import oles.jacek.remote.tv.exceptions.BadTextLengthException;
import oles.jacek.remote.tv.exceptions.NullTextsException;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TextProcessorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    @DisplayName("processTexts (String[])")
    void processTexts() {
        assertThrows(NullTextsException.class, () -> TextProcessor.processTexts(null));
        assertEquals(Stream.empty().count(), TextProcessor.processTexts(new String[0]).count());
    }

    @Test
    @Order(1)
    @DisplayName("processText (String)")
    void processText() {
        Arrays.stream(MainTvRemoteTest.EXAMPLES)
                .forEach(example ->
                        assertEquals(
                                example.output,
                                TextProcessor.processText(example.input)
                        )
                );
    }

    @Test
    @Order(2)
    @DisplayName("processText (String) exceptions")
    void processTextExceptions() {
        testBadStringLengthExceptionMsg(null);
        testBadStringLengthExceptionMsg("");
        testBadStringLengthExceptionMsg("12345678901234567890123456789012");
        testBadStringContentsExceptionMsg("!");
        testBadStringContentsExceptionMsg(" ");
    }

    void testBadStringLengthExceptionMsg(String string) {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.processText(string));
        assertThrows(BadTextLengthException.class, () -> TextProcessor.processText(string));
        try {
            TextProcessor.processText(string);
        } catch (BadTextLengthException e) {
            assertEquals(BadTextLengthException.MESSAGE, e.getMessage());
        }
    }

    void testBadStringContentsExceptionMsg(String string) {
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.processText(string));
        assertThrows(BadTextContentsException.class, () -> TextProcessor.processText(string));
        try {
            TextProcessor.processText(string);
        } catch (BadTextContentsException e) {
            assertEquals(BadTextContentsException.MESSAGE, e.getMessage());
        }
    }
}
