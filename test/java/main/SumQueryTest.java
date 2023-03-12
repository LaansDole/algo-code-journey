package main;

import RMIT.Week1.SumQuery;
import org.junit.jupiter.api.Test;

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
    @Test
    void prefixSumArray1() {
        SumQuery test2 = new SumQuery();
        int[] test2Array;
        test2Array = test2.prefixSumArray(new int[]{7,6,4,6,2,9,4,8}, 8);
        for(int i = 0; i < test2Array.length; i++) {
            System.out.print(test2Array[i]+" ");
        }
    }
}