package test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] a;
    static int X;

    static void input() {
        N = scan.nextInt();
        a = new int[N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
        X = scan.nextInt();
    }

    static boolean binary_search(int[] A, int L, int R, int x) {
        while(L <= R) {
            int mid = (L+R)/2;
            if(A[mid] == x) return true;
            else if(A[mid] > x) R = mid - 1;
            else L = mid + 1;
        }
        return false;
    }

    static void pro() {
        Arrays.sort(a, 1, N+1);
        int ans = 0;
        for(int i = 1; i < N; i++) {
            if (binary_search(a, i+1, N, X - a[i])) ans++;
        }
        sb.append(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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
