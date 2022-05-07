package DP.카드구매하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] a;
    static int[] dp;

    static void input() {
        N = scan.nextInt();
        a = new int [N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
        dp = new int[N+1];
    }

    static void pro() {
        dp[0] = 0;

        for(int i = 1; i <= N; i++) {
            for(int cnt = 1; cnt <= i; cnt++) {
                dp[i] = Math.max(dp[i], dp[i-cnt] + a[cnt]);
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}