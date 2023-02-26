package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumQueryTest {
    @Test
    void prefixSumArray() {
        SumQuery test1 = new SumQuery();
        int[] test1Array;
        test1Array = test1.prefixSumArray(new int[]{3,2,4,5,1,1,5,3}, 8);
        for(int i = 0; i < test1Array.length; i++) {
            System.out.print(test1Array[i]+" ");
        }
    }
}