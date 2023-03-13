package main;

import RMIT.Week1.SumQuery;
import org.junit.jupiter.api.Test;

class SumQueryTest {
    @Test
    void prefixSumArray() {
        int[] test1Array;
        test1Array = SumQuery.prefixSumArray(new int[]{3,2,4,5,1,1,5,3}, 8);
        for (int j : test1Array) {
            System.out.print(j + " ");
        }
    }
    @Test
    void prefixSumArray1() {
        int[] test2Array;
        test2Array = SumQuery.prefixSumArray(new int[]{7,6,4,6,2,9,4,8}, 8);
        for (int j : test2Array) {
            System.out.print(j + " ");
        }
    }
}