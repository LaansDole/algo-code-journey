package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SumQuery {
    public static void main (String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner f_scanner = new FastScanner();
        int arrayLen, numOfQueries;

        arrayLen = f_scanner.nextInt();
        numOfQueries = f_scanner.nextInt();

        long[] longArray = new long[arrayLen];
        long[] prefix_sum = new long[arrayLen+1];
        long sum = 0;

        for(int i = 0; i < arrayLen; i++) {
            longArray[i] = f_scanner.nextInt();
            sum+=longArray[i];
            prefix_sum[i+1] = sum;
        }

        for(int j = 0; j < numOfQueries; j++) {
            int leftRange = f_scanner.nextInt();
            int rightRange = f_scanner.nextInt();
            out.println(prefix_sum[rightRange]-prefix_sum[leftRange-1]);
        }
        out.close();
    }
    //template for FastScanner using BufferedReader
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
