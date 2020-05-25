package oles.jacek.alone.home;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainHomeAloneTest {

    public static class Example {
        private final String[] stringArray;
        private final boolean expectedOutput;

        public Example(String[] stringArray, boolean expectedOutput) {
            this.stringArray = stringArray;
            this.expectedOutput = expectedOutput;
        }

        public String[] getStringArray() {
            return this.stringArray;
        }

        public char[][] getArrayOfCharArrays() {
            return Arrays.stream(this.stringArray)
                    .map(String::toCharArray)
                    .toArray(char[][]::new);
        }

        public boolean getExpectedOutput() {
            return this.expectedOutput;
        }

        ;
    }

    public static final Example[] EXAMPLES = {
            new Example(new String[]{"o # K # o"}, true),
            new Example(new String[]{"# K o # o"}, false),
            new Example(new String[]{
                    "  o             o       #######",
                    "    ##########          #     #",
                    "#####        #      o   #     #",
                    "#          K # ##########     #",
                    "######       # #        o     #",
                    "     ######### ################"
            }, true),
            new Example(new String[]{
                    "  o     #o#     o       #######",
                    "    ##### ####          #     #",
                    "#####        #      o   #     #",
                    "#          K # ##########     #",
                    "######       # #        o     #",
                    "     ######### ################"
            }, false),
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
        Arrays.stream(MainHomeAloneTest.EXAMPLES)
                .forEach(example -> MainHomeAlone.main(
                        example.getStringArray()
                ));
    }

    @Test
    @Order(2)
    @DisplayName("isAlone")
    void isAlone() {
        Arrays.stream(MainHomeAloneTest.EXAMPLES)
                .forEach(example -> assertEquals(
                        example.getExpectedOutput(),
                        MainHomeAlone.isAlone(
                                example.getArrayOfCharArrays()
                        )
                ));
    }
}
