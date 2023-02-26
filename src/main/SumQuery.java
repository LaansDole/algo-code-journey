package main;

import java.util.Scanner;

public class SumQuery {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLen, numOfQueries;
        arrayLen = scanner.nextInt();
        numOfQueries = scanner.nextInt();
        long[] longArray = new long[arrayLen];
        for(int i = 0; i < arrayLen; i++) {
            longArray[i] = scanner.nextInt();
        }
        long[] prefix_sum = new long[arrayLen+1];
        long sum = 0;
        for(int j = 1; j < arrayLen+1; j++) {
            sum+=longArray[j-1];
            prefix_sum[j] = sum;
        }
//        int leftRange;
//        int rightRange;
        for(int j = 0; j < numOfQueries; j++) {
            int leftRange = scanner.nextInt();
            int rightRange = scanner.nextInt();
            System.out.println(prefix_sum[rightRange]-prefix_sum[leftRange-1]);
        }
    }
    public int[] prefixSumArray(int[] intArray, int arrayLen) { //for testing the prefix_array
        int[] prefix_sum = new int[arrayLen+1];
        int sum = 0;
        for(int j = 1; j < arrayLen+1; j++) {
            sum+=intArray[j-1];
            prefix_sum[j] = sum;
        }
        return prefix_sum;
    }
}
