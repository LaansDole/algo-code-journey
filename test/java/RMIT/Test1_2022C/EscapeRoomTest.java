package RMIT.Test1_2022C;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EscapeRoomTest {
    EscapeRoom escapeRoom = new EscapeRoom();
    @Test
    void minOperationsTest() {
        assertEquals(0, escapeRoom.minOperations(null, null));
        escapeRoom.enterRoom("A");
        escapeRoom.enterRoom("B");
        escapeRoom.enterRoom("C");
        assertEquals(3, escapeRoom.minOperations(null, null));
        assertEquals(1, escapeRoom.minOperations(new String[]{"A", "B", "C"}, new String[]{"A", "B"}));
        assertEquals(1, escapeRoom.minOperations(new String[]{"A", "B", "C"}, new String[]{"A", "B", "C", "D"}));
        assertEquals(4, escapeRoom.minOperations(new String[]{"A", "B", "C"}, new String[]{"A", "C", "B"}));
    }

    @Test
    void enterRoom() {
    }

    @Test
    void exitRoom() {
    }
}