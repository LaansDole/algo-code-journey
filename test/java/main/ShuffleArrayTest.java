package main;

import org.junit.jupiter.api.Test;

class ShuffleArrayTest {

    @Test
    void shuffle() {
        ShuffleArray shuf = new ShuffleArray();
        int[] test = new int[6];
        test = shuf.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
        for(int t : test) {
            System.out.println(t);
        }
    }
}