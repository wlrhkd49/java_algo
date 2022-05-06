package DP.더하기6;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] dp;

    static void input() {
        N = scan.nextInt();
        dp = new int[1000001];
    }

    static void pro() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 1000000; i++) {
            dp[i] += dp[i-1];
            dp[i] %= 1000000009;
            dp[i] += dp[i-2];
            dp[i] %= 1000000009;
            dp[i] += dp[i-3];
            dp[i] %= 1000000009;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        for(int i = 1; i <= N; i++) {
            int x = scan.nextInt();

            int res = 0;
            for(int mid = 0; mid <= 3; mid++) {
                if(x - mid >= 0 && (x - mid) % 2 == 0) {
                    res += dp[(x - mid) / 2];
                    res %= 1000000009;
                }
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb);
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
