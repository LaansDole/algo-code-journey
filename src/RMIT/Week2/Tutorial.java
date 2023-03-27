package RMIT.Week2;

import java.util.*;

import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.max;

public class Tutorial {
    // Time complexity: O(N)
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
        // Time complexity: O(N*log(N)) + O(N) = O(N*log(N))
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
    /*
    public static int Problem3(int N) {

        class Plane {
            public final double arrival;
            public final double departure;
            public Plane(double arrival , double departure) {
                this.arrival = arrival;
                this.departure = departure;
            }
        }

        Scanner sc = new Scanner(System.in);

        Plane[] planes = new Plane[N];

        for (int i = 0; i < N; i++) {
            double arrival = sc.nextDouble();
            double departure = sc.nextDouble();
            planes[i] = new Plane(arrival, departure);
        }

        // Approach: there are two types of events: arrival and departure
        // When we scan the events from soonest to latest,
        // if we encounter an arrival event => increase the gates required
        // if we encounter a departure event => decrease the gates required
        // during this process: need to maintain the maximum gates at all points in time

        int[] arrival = new int[N];
        int[] departure = new int[N];

        for (int i = 0; i < N; i++) {
            arrival[i] = (int) planes[i].arrival;
            departure[i] = (int) planes[i].departure;
        }

        Tutorial.mergeSort(arrival, N);
        Tutorial.mergeSort(departure, N);

        int arrivalIndex = 0;
        int departureIndex = 0;
        int gates = 0;
        int maxGates = 0;

        // compare the next arrival event to the next departure event
        // to see which one occurs first, then proceed to the next event of the same type
        // repeat this process until there is no more event to compare
        // Implementation: use two-pointers technique

        while(arrivalIndex < N && departureIndex < N) {
            if(arrival[arrivalIndex] < departure[departureIndex]) {
                gates++;
                arrivalIndex++;
            } else {
                gates--;
                departureIndex++;
            }
            maxGates = Math.max(maxGates, gates);
        }

        return maxGates;
    }

     */
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
//        System.out.print("Gates required: "+ Tutorial.Problem3(6));
        System.out.print("\nProblem 4: Best approach\n");
        int[] result = Tutorial.Problem4(new int[]{2,3,9,6});
        for(int i : result) {
            System.out.println(i);
        }
    }
}
