package oles.jacek.remote.tv;

import oles.jacek.remote.tv.exceptions.NullTextsException;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTvRemoteTest {

    public static class Example {
        public final String input;
        public final int output;

        public Example(String input, int output) {
            this.input = input;
            this.output = output;
        }
    }

    public static final Example[] EXAMPLES = new Example[]{
            new Example("agh", 6),
            new Example("12", 6 + 2),
            new Example("21", 7 + 2),
            new Example("6.", 9 + 5),
            new Example("test", 8 + 4 + 5 + 2),
            new Example("remote", 6 + 6 + 5 + 3 + 2 + 4),
            /**
             * assertEquals(19, 8 + 4 + 5 + 2);
             * assertEquals(26, 6 + 6 + 5 + 3 + 2 + 4);
             **/
            new Example("test_remote", 19 - 6 + 4 + 6 + 26),
    };

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    @DisplayName("main")
    void main() {
        assertThrows(NullTextsException.class, () -> MainTvRemote.getOutputStream(null));
        assertEquals(
                Collections.singletonList("")
                        .toString(),
                MainTvRemote.getOutputStream(new String[0])
                        .collect(Collectors.toList())
                        .toString()
        );
        Arrays.stream(EXAMPLES)
                .forEach(example ->
                        assertEquals(
                                example.output,
                                MainTvRemote.solve(example.input)
                        )
                );
    }

    @Test
    @Order(2)
    @DisplayName("solve")
    void solve() {
        assertThrows(NullTextsException.class, () -> MainTvRemote.solve((String[]) null));
        assertEquals(
                Collections.singletonList("")
                        .toString(),
                intArrayToString(
                        MainTvRemote.solve(new String[0])
                )
        );
        Arrays.stream(EXAMPLES)
                .forEach(example ->
                        assertEquals(
                                example.output,
                                MainTvRemote.solve(example.input)
                        )
                );
    }

    String intArrayToString(int[] intArray) {
        return Arrays.toString(
                Arrays.stream(intArray)
                        .mapToObj(integer -> String.format("%d", integer))
                        .toArray(String[]::new)
        );
    }
}
