package RMIT.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*Acknowledgement: Dr Tri Algorithm 3

*/
public class rangQuery {
    // ignore this, using FastScanner template for runtime optimization
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
            } catch (Exception e){e.printStackTrace();}
        }

        public String next() {
            if (st.hasMoreTokens()) return st.nextToken();
            try {st = new StringTokenizer(br.readLine());}
            catch (Exception e) {e.printStackTrace();}
            return st.nextToken();
        }

        public int nextInt() {return Integer.parseInt(next());}

        public long nextLong() {return Long.parseLong(next());}

        public double nextDouble() {return Double.parseDouble(next());}

        public String nextLine() {
            String line = "";
            if(st.hasMoreTokens()) line = st.nextToken();
            else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
            while(st.hasMoreTokens()) line += " "+st.nextToken();
            return line;
        }
    }
    public static int log2Floor (int x) {
        return (int) Math.floor((Math.log(x)/Math.log(2)));
    }
    public static int[][] minTree(int[] inputArray) {
        int arrayLen = inputArray.length;
        int numRow = log2Floor(arrayLen) + 1;
        int[][] min = new int[numRow][arrayLen];

        min[0] = inputArray; // size range = 1
        for(int row = 0; row < numRow; row++) {
            int rangeCompare = (int) Math.pow(2, row);
            arrayLen -= rangeCompare;
            for(int col = 0; col < arrayLen; col++) {
                int nextRow = row+1;
                int nextCol = col+rangeCompare;
                min[nextRow][col] = Math.min(min[row][col], min[row][nextCol]);
            }
        }
        return min;
    }
    public static int minAtLocation (int left, int right, int[][] arr) {
        int range = right - left + 1;
        if (range==(int) Math.pow(2, log2Floor(range))) {
            return arr[log2Floor(range)][left];
        }
        int rangePower = log2Floor(range);
        return Math.min(
                arr[rangePower][left],
                arr[rangePower][right-(int) Math.pow(2, rangePower)+1]);
    }
    public static void main (String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner f_scanner = new FastScanner();

        int arrayLen, numOfQueries;
        arrayLen = f_scanner.nextInt();
        numOfQueries = f_scanner.nextInt();

        int[] inputArray = new int[arrayLen];
        for(int i = 0; i < arrayLen; i++) {
            inputArray[i] = f_scanner.nextInt();
        }
        int[][] minTree = minTree(inputArray);

        for(int j = 0; j < numOfQueries; j++) {
            int left = f_scanner.nextInt();
            int right = f_scanner.nextInt();
            out.println(minAtLocation(left, right, minTree));
        }
        out.close();
    }
}
