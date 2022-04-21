package 투포인터.수들의합2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void pro() {

        int R = 0, ans = 0, sum = 0;
        for(int L = 1; L <= N; L++) {
            sum -= nums[L-1];

            while(R + 1 <= N && sum < M) {
                R++;
                sum += nums[R];
            }

            if(sum == M) ans++;
        }
        System.out.println(ans);
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