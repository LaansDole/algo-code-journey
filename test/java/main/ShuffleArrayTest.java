package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShuffleArrayTest {

    @Test
    void shuffle() {
        int[] test = new int[6];
        test = ShuffleArray.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
        for(int t : test) {
            System.out.println(t);
        }
    }
}