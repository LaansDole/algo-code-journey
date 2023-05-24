package RMIT.Test2_2023A;

public class P3 {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0,1,5},
                {4,0,3},
                {2,1,0}
        };

        EasyLearning easyLearning = new EasyLearning(A);
        System.out.println(easyLearning.directSequence());
        System.out.println(easyLearning.compare(new int[]{0,2}, new int[]{0,1,2}));
    }
    public static class EasyLearning {
        int[][] matrix;
        private int matrixSize;
        public EasyLearning(int[][] matrix) {
            this.matrix = matrix;
            for(int[] row: matrix) {
                matrixSize++;
            }
        }

        public int directSequence() {
            return matrix[0][matrixSize-1];
        }

        public int compare(int[] seq1, int[] seq2) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 1; i < seq1.length; i++) {
                sum1 += matrix[i-1][i];
            }

            for(int i = 1; i < seq2.length; i++) {
                sum1 += matrix[i-1][i];
            }

            if(sum1 > sum2) {
                return 1;
            } else if (sum1 == sum2) {
                return 0;
            }
            return -1;
        }

//        public int bestSequence() {
//
//        }
    }
}

