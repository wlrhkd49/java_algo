package 그래프.결혼식;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
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
    }

    static int bfs(int start) {
        int cnt = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        Q.add(start);
        dist[start] = 0;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            if (1 <= dist[x] && dist[x] <= 2) cnt++;
            if (dist[x] == 2) continue;

            for(int y : adj[x]) {
                if(dist[y] != -1) continue;

                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        return cnt;
    }

    static void pro() {
        dist = new int[N+1];
        System.out.println(bfs(1));
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
