package 트리.가장가까운공통조상;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, A, B;
    static int[] parent;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        parent = new int[N+1];
        visit = new boolean[N+1];
        for(int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            parent[y] = x;
        }
    }

    static void pro() {
        int x = scan.nextInt(), y = scan.nextInt();

        while( x > 0 ) {
            visit[x] = true;
            x = parent[x];
        }

        while( y > 0 && !visit[y] ) {
            y = parent[y];
        }

        System.out.println(y);
    }

    public static void main(String[] args) {
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            input();
            pro();
        }
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
