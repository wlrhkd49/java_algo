package 투포인터.배열합치기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] a, b;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N+1];
        b = new int[M+1];
        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
        for(int i = 1; i <= M; i++) {
            b[i] = scan.nextInt();
        }
    }

    static void pro() {
        int L = 1, R = 1;
        while(L <= N && R <= M) {
            if(a[L] <= b[R]) sb.append(a[L++]).append(' ');
            else sb.append(b[R++]).append(' ');
        }
        while(L <= N) sb.append(a[L++]).append(' ');
        while(R <= M) sb.append(b[R++]).append(' ');

        System.out.println(sb);
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
