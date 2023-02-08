package main;
import org.junit.jupiter.api.Test;
class FruitBasketTest {
    @Test
    void totalFruitTest() {
        FruitBasket test1 = new FruitBasket();
        int case1;
        case1 = test1.totalFruit(new int[]{1, 2, 3, 2, 2});
        System.out.println("Output: "+case1);
        System.out.println("Expected: 4, "+(case1==4));
    }
    @Test
    void totalFruitTest2() {
        FruitBasket test2 = new FruitBasket();
        int case2;
        case2 = test2.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
        System.out.println("Output: "+case2);
        System.out.println("Expected: 5, "+(case2==5));
    }
    @Test
    void totalFruitTest3() {
        FruitBasket test3 = new FruitBasket();
        int case3;
        case3 = test3.totalFruit(new int[]{1,0});
        System.out.println("Output: "+case3);
        System.out.println("Expected: 2, "+(case3==2));
    }
    @Test
    void totalFruitTest4() {
        FruitBasket test4 = new FruitBasket();
        int case4;
        case4 = test4.totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6});
        // the biggest difference with other tests is that the break point at two consecutive type
        // check if how many consecutive there are and then return position - consecutive
        System.out.println("Output: " + case4);
        System.out.println("Expected: 5, " + (case4 == 5));
    }
}