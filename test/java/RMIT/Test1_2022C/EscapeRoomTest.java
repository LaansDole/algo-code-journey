package RMIT.Test1_2022C;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscapeRoomTest {

    @Test
    void minOperations() {
        new EscapeRoom();
        assertAll(
                () -> assertEquals(1, EscapeRoom.minOperations(
                        new String[]{"A","B","C"},
                        new String[]{"A","B"})
                ),
                () -> assertEquals(3, EscapeRoom.minOperations(
                        new String[]{"A","B","C"},
                        new String[]{"A","C"})
                ),
                () -> assertEquals(6, EscapeRoom.minOperations(
                        new String[]{"A","B","C"},
                        new String[]{"B","A","D"})
                ),
                () -> assertEquals(0, EscapeRoom.minOperations(
                        new String[]{"A","B","C"},
                        new String[]{"A","B","C"})
                )
        );
    }
}