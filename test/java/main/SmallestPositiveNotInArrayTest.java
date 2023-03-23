package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestPositiveNotInArrayTest {

    @Test
    void solutionTest() {
        assertAll("Test for finding smallest number",
            () -> assertEquals(5, SmallestPositiveNotInArray.solution(new int[]{1, 3, 6, 4, 1, 2})),
            () -> assertEquals(4, SmallestPositiveNotInArray.solution(new int[]{1, 2, 3})),
            () -> assertEquals(1, SmallestPositiveNotInArray.solution(new int[]{-1,-3}))
        );
    }
}