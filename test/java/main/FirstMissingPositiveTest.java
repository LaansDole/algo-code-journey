package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstMissingPositiveTest {

    @Test
    void solutionTest() {
        assertAll("Test for finding smallest number",
            () -> assertEquals(5, FirstMissingPositive.solution(new int[]{1, 3, 6, 4, 1, 2})),
            () -> assertEquals(4, FirstMissingPositive.solution(new int[]{1, 2, 3})),
            () -> assertEquals(1, FirstMissingPositive.solution(new int[]{-1,-3})),
            () -> assertEquals(10, FirstMissingPositive.solution(new int[]{1,2,3,4,5,6,7,8,9,20}))
        );
    }
}