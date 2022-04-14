package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adj;
    static int[] a;
    static int[][] Dy;
    static int N, R, Q;

    static void input() {
        N = scan.nextInt();
        a = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x, int prev) {
        Dy[x][0] = 0;
        Dy[x][1] = a[x];

        for(int y : adj[x]) {
            if(y == prev) continue;
            dfs(y, x);
            // 아래 자식들의 개수 더해주기

            // 1. x가 선택되지 않으면 자식 중 자식을 선택하거나, 선택하지않거나 중 큰 값을 선택
            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            // 2. x가 선택됐으므로 자식은 전부 선택되면 안된다.
            Dy[x][1] += Dy[y][0];
        }
    }
    static void pro() {
        Dy = new int[N+1][2];

        dfs(1, -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));
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
