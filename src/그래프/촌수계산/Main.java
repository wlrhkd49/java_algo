package 그래프.촌수계산;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int start, dest;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        start = scan.nextInt();
        dest = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        dist = new int[N+1];
        visit = new boolean[N+1];
    }

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visit[start] = true;

        while(!Q.isEmpty()) {
            int x = Q.poll();

            for(int y : adj[x]) {
                if(visit[y]) continue;
                Q.add(y);
                visit[y] = true;
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs(start);
        if(dist[dest] == 0) System.out.println(-1);
        else System.out.println(dist[dest]);
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