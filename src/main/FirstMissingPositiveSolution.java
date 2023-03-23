package main;

public class FirstMissingPositiveSolution {

    // Time complexity: O(N)
    // Space complexity: O(1)
    public int bestSolution(int[] numbers) {
        int n = numbers.length;
        int i = 0;
        while (i < n) {
            if (numbers[i] > 0 && numbers[i] <= n && numbers[numbers[i] - 1] != numbers[i]) {
                // swap numbers[i] with numbers[numbers[i]-1] to put numbers[i] in its correct position
                int temp = numbers[i];
                numbers[i] = numbers[temp - 1];
                numbers[temp - 1] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (numbers[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    public int generalSolution(int[] numbers) {
        int N = numbers.length;
        boolean[] present = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            if (numbers[i] > 0 && numbers[i] <= N) {
                present[numbers[i]] = true;
            }
        }
        for (int i = 1; i <= N+1; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return -1; // this line is not necessary because we know that there is always a positive integer missing
    }
}
