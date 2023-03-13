package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandDistanceTest {

    @Test
    void maxDistance() {
        assertAll(
                () -> assertEquals(2,
                        LandDistance.maxDistance(new int[][]{
                                {1,0,1},
                                {0,0,0},
                                {1,0,1}
                        })),
                () -> assertEquals(4,
                        LandDistance.maxDistance(new int[][]{
                                {1,0,0},
                                {0,0,0},
                                {0,0,0}
                        })),
                () -> assertEquals(-1,
                        LandDistance.maxDistance(new int[][]{
                                {3,0,3},
                                {0,0,0},
                                {3,0,3}
                        })),
                () -> assertEquals(2,
                        LandDistance.maxDistance(new int[][]{
                                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}
                        }))
        );
    }
}