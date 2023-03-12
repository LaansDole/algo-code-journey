package main;

public class BinarySearch {
    public static int binarySearch(int[] sortedNumbers, int target, int low, int high) {
        if(low > high) {
            return -1;
        } else {
            int mid_index = (low+high)/2;
            if (target == sortedNumbers[mid_index]) {
                return mid_index;
            } else if (target < sortedNumbers[mid_index]) {
                return binarySearch(sortedNumbers, target, low, mid_index-1);
            } else {
                return binarySearch(sortedNumbers, target, mid_index+1, high);
            }
        }
    }
    public int search(int[] sortedNumbers, int target) {
        int high = sortedNumbers.length - 1;
        int result = binarySearch(sortedNumbers, target, 0, high);
        return result;
    }
}
