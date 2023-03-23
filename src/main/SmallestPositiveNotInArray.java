package main;

import java.util.HashSet;
import java.util.Set;

/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositiveNotInArray {
    public static void mergeSort(int[] arr, int arrayLength) {
        if (arrayLength >= 2) {
            int mid = arrayLength / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[arrayLength - mid];

            for (int i = 0; i < mid; i++) {
                leftArray[i] = arr[i];
            }
            for (int j = mid; j < arrayLength; j++) {
                rightArray[j - mid] = arr[j];
            }
            mergeSort(leftArray, mid);
            mergeSort(rightArray, arrayLength - mid);

            merge(arr, leftArray, rightArray, mid, arrayLength - mid);
        }
    }
    public static void merge(
            int[] arr, int[] leftArray, int[] rightArray, int leftArrayLength, int rightArrayLength) {

        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;
        while (leftIndex < leftArrayLength && rightIndex < rightArrayLength) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                // Change operator "<=" to ">" to reverse merge sort
                arr[arrayIndex++] = leftArray[leftIndex++];
            } else {
                arr[arrayIndex++] = rightArray[rightIndex++];
            }
        }
        // Add the rest of the elements to the left array and right array
        while (leftIndex < leftArrayLength) {
            arr[arrayIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArrayLength) {
            arr[arrayIndex++] = rightArray[rightIndex++];
        }
    }

    // Time complexity: O(N*logN) + O(N+k) + O(N)
    public static int solution(int[] A) {
        int arrayLength = A.length;
        mergeSort(A, arrayLength);

        int smallest = 1;
        if(A[arrayLength-1] > 0) {
            Set<Integer> set = new HashSet<>();
            for(int ele : A) {
                set.add(ele);
            }

            for(int element : set) {
                if(element <= 0) {
                    continue;
                } else {
                    if(smallest != element) {
                        return smallest;
                    } else {
                        smallest++;
                    }
                }
            }
        }
        return smallest;
    }
}
