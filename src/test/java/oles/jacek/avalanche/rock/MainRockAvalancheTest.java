package oles.jacek.avalanche.rock;

import oles.jacek.avalanche.rock.exceptions.NullSlopeLevelsException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainRockAvalancheTest {
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
        assertThrows(NullSlopeLevelsException.class, () -> MainRockAvalanche.solve(null));
        assertEquals(new int[]{0, 0, 2}[0], MainRockAvalanche.solve(new String[]{"ooo", "_\\."})[0]);
        assertEquals(new int[]{0, 0, 2}[1], MainRockAvalanche.solve(new String[]{"ooo", "_\\."})[1]);
        assertEquals(new int[]{0, 0, 2}[2], MainRockAvalanche.solve(new String[]{"ooo", "_\\."})[2]);
        assertEquals(
                MainRockAvalanche.intArrayToOutputString(
                        new int[]{0, 0, 2}
                ),
                MainRockAvalanche.intArrayToOutputString(
                        MainRockAvalanche.solve(
                                new String[]{"ooo", "_\\."}
                        )
                )
        );
        assertEquals(
                "0 0 2",
                MainRockAvalanche.intArrayToOutputString(
                        MainRockAvalanche.solve(
                                new String[]{"ooo", "_\\."}
                        )
                )
        );
    }
}
