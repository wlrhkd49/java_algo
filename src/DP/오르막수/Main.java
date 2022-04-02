package DP.오르막수;

import java.io.*;
import java.util.StringTokenizer;

// 11057
public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][10];
    }

    static void pro() {
        // 초기값 구하기
        for(int num = 0; num < 10; num++) {
            Dy[1][num] = 1;
        }

        // 점화식을 토대로 Dy 배열 채우기
        for(int len = 2; len <= N; len++) {
            for(int num = 0; num < 10; num++) {
                // Dy[len][num] := ?
                for(int prev = 0; prev <= num; prev ++) {
                    Dy[len][num] = Dy[len-1][prev];
                    Dy[len][num] %= 10007;
                }
            }
        }

        // Dy 배열로 정답 계산하기
        int ans = 0;
        for(int num = 0; num < 10; num++) {
            ans += Dy[N][num];
            ans %= 10007;
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