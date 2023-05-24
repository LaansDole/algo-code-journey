package RMIT.Test2_2023A;

public class DoraCake {
    public static void main(String[] args) {
        Topic topic1 = new Topic(8.0, 7.0);
        Topic topic2 = new Topic(10.0, 8.0);
        Topic topic3 = new Topic(5.0, 3.0);
        DoraCake cake = new DoraCake((new Topic[]{topic1 , topic2 , topic3}) , 10);
        System.out.println(cake.unlimitedCake());
        System.out.println(cake.weightByNumber(2));
        System.out.println(cake.largestWeight());


    }
    public static class Topic {
        double Weight;
        double S; // printed Surface area
        public Topic(double Weight, double S) {
            this.Weight = Weight;
            this.S = S;
        }
    }

    static class MergeSort {
        void mergeSort(double[] arr) {
            if (arr.length > 1) {
                int n = arr.length;
                int middle = n / 2;

                // create 2 sub-arrays from arr
                double[] sub1 = new double[middle];
                for (int i = 0; i < middle; i++) {
                    sub1[i] = arr[i];
                }
                double[] sub2 = new double[n - middle];
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
        void merge(double[] sub1, double[] sub2, double[] dest) {
            int p1 = 0, p2 = 0, pDest = 0;  // pointers to 3 arrays
            while (p1 < sub1.length && p2 < sub2.length) {
                if (sub1[p1] <= sub2[p2]) {
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

    Topic[] topics;
    double A; // cake surface Area
    public DoraCake(Topic[] topics, double A) {
        this.topics = topics;
        this.A = A;
    }

    public double unlimitedCake() {
        double sum = 0;
        for(Topic topic : topics) {
            sum+=topic.Weight;
        }
        return sum;
    }

    public double weightByNumber(int X) {
        double[] topicW = new double[topics.length];
        for(int i = 0; i < topics.length; i++) {
            topicW[i] = topics[i].Weight;
        }
        new MergeSort().mergeSort(topicW);

        double largestW = 0.0;
        for(int j = 0; j < X;  j++) {
            largestW += topicW[topicW.length-j-1];
        }
        return largestW;
    }

    public double largestWeight() {
        boolean[] selected = new boolean[topics.length];
        double[] surfaces = new double[topics.length];
        for (int i = 0; i < topics.length; i++) {
            surfaces[i] = topics[i].S;
        }
        double[] weights = new double[topics.length];
        for (int i = 0; i < topics.length; i++) {
            weights[i] = topics[i].Weight;
        }

        for (int i = 0; i < topics.length; i++) {
            selected[i] = false;
        }

        SubSetGenerator.selected = selected;
        double w = SubSetGenerator.subset(A, weights, surfaces, topics.length);

        return w;
    }

    class SubSetGenerator {
        static boolean[] selected;
        static double subset(double A, double[] w, double[] s, int index) {
            if (A == 0 || index == 0) {
                return 0;
            }

            if (s[index - 1] > A) {
                return subset(A, w, s, index - 1);
            }

            double case1 = w[index - 1] + subset(A - s[index - 1], w, s, index - 1);
            double case2 = subset(A, w, s, index - 1);

            if (case1 > case2) {
                selected[index - 1] = true;
                return case1;
            } else {
                return case2;
            }
        }
    }
}
