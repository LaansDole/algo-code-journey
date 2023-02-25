package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandDistanceTest {

    @Test
    void maxDistance() {
        LandDistance test1 = new LandDistance();
        int case1;
        case1=test1.maxDistance(new int[][]{
                {1,0,1},
                {0,0,0},
                {1,0,1}});
        System.out.println("Output: "+case1);
        System.out.println("Expected: 2, "+(case1==2));
    }
    @Test
    void maxDistance1_1() {
        LandDistance test1_1 = new LandDistance();
        int case1_1;
        case1_1=test1_1.maxDistance(new int[][]{
                {1,0,0},
                {0,0,0},
                {0,0,0}});
        System.out.println("Output: "+case1_1);
        System.out.println("Expected: 4, "+(case1_1==4));
    }
    @Test
    void maxDistance2() {
        LandDistance test2 = new LandDistance();
        int case2;
        case2=test2.maxDistance(new int[][]{
                {3,0,3},
                {0,0,0},
                {3,0,3}});
        System.out.println("Output: "+case2);
        System.out.println("Expected: -1, "+(case2==-1));
    }
    @Test
    void maxDistance3() {
        LandDistance test3 = new LandDistance();
        int case3;
        case3 = test3.maxDistance(new int[][]{
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}});
        System.out.println("Output: " + case3);
        System.out.println("Expected: 2, " + (case3 == 2));
    }
}