package main;

public class ShuffleArray {
    ShuffleArray() {}
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        boolean shuf = true;
        int x = 0;
        int y = n;
        int i = 0;
        while(y<2*n) {
            if(shuf) {
                result[i] = nums[x];
                x++;
            } else {
                result[i] = nums[y];
                y++;
            }
            shuf = !shuf;
            i++;
        }
        return result;
    }
}
