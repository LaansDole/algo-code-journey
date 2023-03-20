package RMIT.Week2;

import java.util.*;

import static java.lang.Double.POSITIVE_INFINITY;

public class Tutorial {
    // Time complexity: O(N + O(N)) + O(N) = O(N^2)
    public static void Problem2SetCase (int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int element : arr) { // O(N = arr)
            set.add(element); // Finding similar element in the set, O(N)
        }
        for (int element : set) {
            System.out.println(element);
        }
    }
    public static class Problem2NotSetCase {
        // Time complexity: O(N + O(N) = O(N^2)
        public static void BruteForceApproach(int[] arr) {
            int N = arr.length;
            for (int i = 0; i < arr.length; i++) {
                boolean found = false;
                for (int j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(arr[i]);
                }
            }
        }
        // Time complexity: O(N*log(N) +
        public static void SortThenSearchApproach(int[] arr) {
            Tutorial.mergeSort(arr, arr.length); // O(N*logN)
            System.out.println(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i-1]) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    public static void Problem3(int N) {
        Scanner sc = new Scanner(System.in);

        ArrayList<double[]> planes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double[] planeTimeStamp = new double[2];
            planeTimeStamp[0] = sc.nextDouble(); // depart time
            planeTimeStamp[1] = sc.nextDouble(); // arrival time
            planes.add(planeTimeStamp);
        }
        // TODO: Implement the correct algorithm for all possible cases
        // https://stackoverflow.com/questions/69205144/java-concurrent-airport-simulation-how-to-allow-planes-to-access-different-gat

        int gate = 1;

        for (int i = 1; i < N-1; i++) {
            if (planes.get(i)[0] > planes.get(i-1)[1]) {
                continue;
            } else {
                gate++;
            }
        }
        System.out.println("Numbers of gate required: "+gate);
    }
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
    public static int[] Problem4(int[] arr) {
        Tutorial.mergeSort(arr, arr.length);
        int[] result = new int[2];

        // Case 1: the sorted array is positive
        if (arr[0] >= 0) {
            result[0] = arr[0];
            result[1] = arr[1];
        }
        // Case 2: the sorted array is negative
        else if (arr[arr.length-1] < 0) {
            result[0] = arr[arr.length-2]; // The second last element
            result[1] = arr[arr.length-1];
        }
        // Case 3: the sorted array is neutral
        else {
            int closest = (int) POSITIVE_INFINITY; // Initialize the starting sum value
            int leftIndex = 0;
            int rightIndex = arr.length-1;

            while (leftIndex < rightIndex) {
                int sum = arr[leftIndex] + arr[rightIndex];
                if (closest > Math.abs(sum)) {
                    closest = Math.abs((sum));
                    result[0] = arr[leftIndex];
                    result[1] = arr[rightIndex];
                }

                if (sum == 0) {
                    result[0] = arr[leftIndex];
                    result[1] = arr[rightIndex];
                    break;
                }
                else if (sum > 0) {
                    rightIndex--;
                }
                else {
                    leftIndex++;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.print("Problem 2: Case 2 - Without the Set ADT\n");
        System.out.print("\t- Brute Force Approach\n");
        Tutorial.Problem2NotSetCase.BruteForceApproach(new int[]{6, 8, 10, 11, 6, 10});
        System.out.print("\t- Sort Then Search Approach\n");
        Tutorial.Problem2NotSetCase.SortThenSearchApproach(new int[]{6, 8, 10, 11, 6, 10});
        System.out.print("Problem 2: Case 2 - With the Set ADT\n");
        Tutorial.Problem2SetCase(new int[]{6, 8, 10, 11, 6, 10});
        System.out.print("Problem 3\n");
        Tutorial.Problem3(6);
        System.out.print("Problem 4: Best approach\n");
        Tutorial.Problem4(new int[]{2,3,9,6});
    }
}
