package main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FruitBasketTest {
    @Test
    void totalFruit() {
        assertAll(
                () -> assertEquals(4, FruitBasket.totalFruit(new int[]{1, 2, 3, 2, 2})),
                () -> assertEquals(5, FruitBasket.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4})),
                () -> assertEquals(2, FruitBasket.totalFruit(new int[]{1,0})),
                () -> assertEquals(5, FruitBasket.totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}))
                );
    }
}