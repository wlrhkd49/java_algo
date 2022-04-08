package test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A, cnt;

    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean isGood(int idx) {
        int L = 1, R = N;
        int goal = A[idx];
        while (L < R) {
            int target = A[L] + A[R];
            if (L == idx) L++;
            else if (R == idx) R--;
            else {
                if (target == goal) return true;
                if (goal > target) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return false;
    }

    static void pro() {
        Arrays.sort(A, 1, N+1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if(isGood(i)) {
                ans++;
            }
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
