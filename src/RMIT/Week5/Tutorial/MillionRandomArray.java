package RMIT.Week5.Tutorial;

import java.util.Random;
public class MillionRandomArray {
    public static int[] array;
    public static int[] generateMillionRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000) + 1;
        }
        return array;
    }
}
