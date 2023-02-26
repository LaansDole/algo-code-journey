package main;

import java.io.*;
import java.util.*;

public class SumQuerySolution {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int n = fs.nextInt();
        int q = fs.nextInt();
        long[] prefix_sum = new long[n + 1];
        prefix_sum[0] = 0;
        for(int i = 1; i <= n; i++){
            int x = fs.nextInt();
            prefix_sum[i] = prefix_sum[i - 1] + x;
        }
        while(q-- > 0){
            int l = fs.nextInt();
            int r = fs.nextInt();
            pw.println(prefix_sum[r] - prefix_sum[l - 1]);
        }
        pw.close();
    }

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

}
