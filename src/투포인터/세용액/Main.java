package 투포인터.세용액;

import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        a = new int[N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a, 1, N+1);
    }

    static void pro() {
        long best_sum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3 = 0;

        for(int i = 1; i <= N - 2; i++) {
            int target = a[i];
            int L = i + 1, R = N;
            while( L < R ) {
                if(best_sum > Math.abs((long)target + a[L] + a[R])) {
                    best_sum = Math.abs((long)target + a[L] + a[R]);
                    v1 = target;
                    v2 = a[L];
                    v3 = a[R];
                }
                if(a[L] + a[R] > -target) R--;
                else L++;
            }
        }
        sb.append(v1).append(' ').append(v2).append(' ').append(v3);
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
