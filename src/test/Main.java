package test;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, ans;
    static ArrayList<Edge>[] adj;

    static class Edge {
        int y;
        int cost;

        public Edge(int _y, int _cost) {
            this.y = _y;
            this.cost = _cost;
        }
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), cost = scan.nextInt();
            adj[x].add(new Edge(y, cost));
            adj[y].add(new Edge(x, cost));
        }
    }

    static void dfs(int x, int prev, int goal, int dist) {
        if(x == goal) {
            ans = dist;
            return;
        }
        for(Edge e : adj[x]) {
            if(e.y == prev) continue;
            dfs(e.y, x, goal, dist + e.cost);
        }

    }

    static void pro() {
        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            dfs(x, -1, y, 0);
            System.out.println(ans);
        }
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
