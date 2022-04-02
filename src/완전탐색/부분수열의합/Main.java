package 완전탐색.부분수열의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, S;
    static int ans;
    static int[] arr;

    static void input() {
        ans = 0;
        N = scan.nextInt();
        S = scan.nextInt();
        arr = new int[N+1];
        for(int i = 1; i<=N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void pro(int k, int value) {
        if(k == N+1) {
            if(value == S) ans++;
//            System.out.println(ans);
        }
        else {
            pro(k+1, value + arr[k]);
            pro(k+1, value);
        }
    }

    public static void main(String[] args) {
        input();
        pro(1, 0);
        if(S==0) ans--; // 진부분집합 제외 ( 즉, 공집합이 답인 경우를 제외한다. )
        System.out.println(ans);
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