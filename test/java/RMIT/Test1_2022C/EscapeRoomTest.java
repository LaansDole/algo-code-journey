package RMIT.Test1_2022C;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscapeRoomTest {

    @Test
    void minOperations1() {
        EscapeRoom test = new EscapeRoom();
        int testMinOperations;
        testMinOperations = test.minOperations(
                new String[]{"A","B","C"},
                new String[]{"A","B"});
        System.out.println("Output: "+testMinOperations);
        System.out.println("Expected: 1, "+(testMinOperations==1));
    }
    @Test
    void minOperations2() {
        EscapeRoom test = new EscapeRoom();
        int testMinOperations;
        testMinOperations = test.minOperations(
                new String[]{"A","B","C"},
                new String[]{"A","C"});
        System.out.println("Output: "+testMinOperations);
        System.out.println("Expected: 3, "+(testMinOperations==3));
    }
    @Test
    void minOperations3() {
        EscapeRoom test = new EscapeRoom();
        int testMinOperations;
        testMinOperations = test.minOperations(
                new String[]{"A","B","C"},
                new String[]{"B","A","D"});
        System.out.println("Output: "+testMinOperations);
        System.out.println("Expected: 6, "+(testMinOperations==6));
    }
    @Test
    void minOperations4() {
        EscapeRoom test = new EscapeRoom();
        int testMinOperations;
        testMinOperations = test.minOperations(
                new String[]{"A","B","C"},
                new String[]{"A","B","C"});
        System.out.println("Output: "+testMinOperations);
        System.out.println("Expected: 0, "+(testMinOperations==0));
    }
}