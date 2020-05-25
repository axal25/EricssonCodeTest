package oles.jacek.avalanche.rock;

import oles.jacek.avalanche.rock.exceptions.BadSlopeLevelStringLengthException;
import oles.jacek.avalanche.rock.exceptions.BadSlopeLevelsArrayLengthException;
import oles.jacek.avalanche.rock.exceptions.MovableRockNotAtTopSlopeLevelException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SlopeLevelParserTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    @DisplayName("parseSlopeLevels")
    void parseSlopeLevels() {
        SlopeLevelsParser.parseSlopeLevels(new String[]{"ooo", "_\\."}); // todo: FIXME

        assertThrows(BadSlopeLevelsArrayLengthException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{}));
        assertThrows(BadSlopeLevelsArrayLengthException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));

        assertThrows(BadSlopeLevelStringLengthException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{"ooo", "_\\.."}));
        assertThrows(BadSlopeLevelStringLengthException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{"", ""}));
        assertThrows(BadSlopeLevelStringLengthException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{
                "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234",
                "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234567890" +
                        "1234"
        }));

        assertThrows(MovableRockNotAtTopSlopeLevelException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{"ooo", "_\\o"}));
        assertThrows(MovableRockNotAtTopSlopeLevelException.class, () -> SlopeLevelsParser.parseSlopeLevels(new String[]{"ooo", "_\\.", "_\\o"}));
    }
}
