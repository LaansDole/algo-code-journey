package main;

public class s3963207Problem1 {
    public static void main(String[] args) {
        double[][] TriTask = new double[][]{
                {3, 9},
                {2, 2},
                {4, 10}
        };

        AnTaskOrdering taskOrdering = new AnTaskOrdering(TriTask);
        System.out.println(taskOrdering.currentHappiness());
//        taskOrdering.funOnlyHappiness();
        System.out.println(taskOrdering.funOnlyHappiness());
    }

    public static class AnTaskOrdering {
        double fun;
        double difficulty;
        double[][] taskOrder;
        private int taskNum;
        // happiness = total (task[i].fun + task[j].difficulty)
        public AnTaskOrdering(double[][] taskOrder) {
            this.taskOrder = taskOrder;
            taskNum = taskOrder.length;
        }

        // Complexity: O(N) where N is the number of tasks
        public double currentHappiness() {
            double totalFun = 0;
            double totalDiff = 0;
            for(int i = 1; i < taskNum; i++) {

                // Calculate the total fun, increase
                // if current fun > previous fun, take it
                if(taskOrder[i][0] > taskOrder[i-1][0]) {
                    totalFun += taskOrder[i][0];
                }

                // Calculate the total diff, decrease
                // if current diff < previous diff, take it
                if(taskOrder[i][1] < taskOrder[i-1][1]) {
                    totalDiff += taskOrder[i][1];
                }
            }
            return totalFun + totalDiff; // total happiness
        }

        // Average complexity: O(NlogN) + O(N) = O(N)
        public double funOnlyHappiness() {
//            double[][] tasks = taskOrder;
            new MergeSort().mergeSort(taskOrder);
//            for(double[] task: tasks) {
//                System.out.println("Fun "+task[0]+" Diff "+task[1]);
//            }
            return currentHappiness();
        }
        static class MergeSort {
            private void mergeSort(double arr[][]) {
                if (arr.length > 1) {
                    int n = arr.length;
                    int middle = n / 2;

                    // create 2 sub-arrays from arr
                    double[][] sub1 = new double[middle][2];
                    for (int i = 0; i < middle; i++) {
                        sub1[i] = arr[i];
//                System.out.println("Fun "+sub1[i][0]+" Diff "+sub1[i][1]);
                    }
                    double[][] sub2 = new double[n - middle][2];
                    for (int i = middle; i < n; i++) {
                        sub2[i - middle] = arr[i];
                    }

                    // sort first and second halves
                    mergeSort(sub1);
                    mergeSort(sub2);

                    // merge sub1 and sub2 into the original array
                    merge(sub1, sub2, arr);
                }
            }

            // merge two sub-arrays sub1 and sub2 into the array dest
            private void merge(double[][] sub1, double[][] sub2, double[][] dest) {
                int p1 = 0, p2 = 0, pDest = 0;  // pointers to 3 arrays
                while (p1 < sub1.length && p2 < sub2.length) {
                    if (sub1[p1][0] <= sub2[p2][0]) {
                        dest[pDest] = sub1[p1];
                        p1++;
                    } else {
                        dest[pDest] = sub2[p2];
                        p2++;
                    }
                    pDest++;
                }

                // copy remaining elements, if any
                while (p1 < sub1.length) {
                    dest[pDest++] = sub1[p1++];
                }
                while (p2 < sub2.length) {
                    dest[pDest++] = sub2[p2++];
                }
            }
        }
//        public double maxHappiness() {
//
//        }
    }
}


