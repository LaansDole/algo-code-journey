package RMIT.Week2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void problem4() {
        assertAll(
                () -> assertEquals(2, Tutorial.Problem4(new int[]{2,3,9,6})[0]),
                () -> assertEquals(3, Tutorial.Problem4(new int[]{2,3,9,6})[1]),

                () -> assertEquals(-6, Tutorial.Problem4(new int[]{-22,-3,-19,-6})[0]),
                () -> assertEquals(-3, Tutorial.Problem4(new int[]{-22,-3,-19,-6})[1])
        );
    }
}