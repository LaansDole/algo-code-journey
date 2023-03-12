package RMIT.Week1;

import java.util.*;

public class Tutorial {
    // Problem 1 prints out the second-highest value in an array
    public static void Problem1(int[] A) {
        int max = A[0];
        int second_max = A[1];
        if (max < second_max) {
            int temp = max;
            max = second_max;
            second_max = temp;
        }
        for(int i=0; i<A.length-1; i++) {
            if(A[i] > max) {
                second_max = max;
                max = A[i];
            } else if (A[i] > second_max) {
                second_max = A[i];
            }
        }
        System.out.println("Second max: " +second_max);
    }
    // Problem 2 prints out the missing value from the array compared with the N+1 length consecutive array
    public static void Problem2(int N, int[] A) {
        int sum_to_N = (N+1)*N/2;
        int sum_arr = A[0];
        for(int i=1; i<N; i++) {
            sum_arr += A[i];
        }
        int missing_value = sum_to_N - sum_arr;
        System.out.println("Missing value: "+missing_value);
    }
    // TODO: Problem 2.5 checks if the elements in the array is in a consecutive order
    /*
    For example:
    [4,5,6,7] -> true
    [5,6,8,7] -> true
    [1,3,4] -> false
     */
    // if max_value - min_value = array.length - 1, it is true and prints out true
    public static boolean Problem2_5(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int value : arr) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
        }
        return (maxValue - minValue) == arr.length - 1;
    }

    // TODO: Problem 3: algorithm to check whether the two sequences are permutations of the same set.
    /*
    set1 = new Set
    while ((ele = seq1.next()) != false)
        set1.add(ele)

    while ((ele = seq2.next()) != false)
        sizeBefore = set1.size()
        set1.remove(ele)
        sizeAfter = set1.size()
        if (sizeBefore == sizeAfter)
            return false

    if (set1.size == 0)
        return true

    return false
    */
    public static boolean Problem3(ArrayList<Integer> seq1, ArrayList<Integer> seq2) {
        Set<Integer> set = new HashSet<>();
        ListIterator<Integer> itr1 = seq1.listIterator();
        ListIterator<Integer> itr2 = seq2.listIterator();
        while (itr1.hasNext()) {
            set.add(itr1.next());
        }
        while (itr2.hasNext()) {
            int sizeBefore = set.size();
            set.remove(itr2.next());
            int sizeAfter = set.size();
            if (sizeBefore == sizeAfter) {
                return false;
            }
        }

        return set.size() == 0;
    }
    public static void main(String[] args) {
        Tutorial.Problem1(new int[]{7, 3, 1, 9, 10});

        Tutorial.Problem2(5, new int[]{1, 2, 3, 4, 5});

        System.out.println(Tutorial.Problem2_5(new int[]{6, 8, 10, 9, 7}));

        ArrayList<Integer> seq1Test = new ArrayList<>();
        ArrayList<Integer> seq2Test = new ArrayList<>();

        seq1Test.add(1);
        seq1Test.add(2);
        seq1Test.add(3);
        seq1Test.add(4);

        seq2Test.add(1);
        seq2Test.add(5);
        seq2Test.add(2);
        seq2Test.add(3);

        System.out.println(Tutorial.Problem3(seq1Test, seq2Test));
    }
}