package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandDistanceTest {

    @Test
    void maxDistance() {
        LandDistance test1 = new LandDistance();
        int case1;
        case1=test1.maxDistance(new int[][]{{1,0,1}, {0,0,0}, {1,0,1}});
        System.out.println("Output: "+case1);
        System.out.println("Expected: 2, "+(case1==2));    }
}