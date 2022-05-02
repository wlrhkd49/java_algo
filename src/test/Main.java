package test;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int N, M, vertexCnt, edgeCnt;

    static void input() {
        visit = new boolean[N+1];
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

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visit[start] = true;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            vertexCnt++;
            edgeCnt += adj[x].size();
            visit[x] = true;

            for(int y : adj[x]) {
                if(visit[y]) continue;
                Q.add(y);
            }
        }
    }

    static void pro(int cnt) {
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            vertexCnt = 0;
            edgeCnt = 0;
            bfs(i);

            if(edgeCnt == (vertexCnt - 1) * 2) ans++;
        }
        sb.append("Case " + cnt+ ": ");
        if(ans == 0) sb.append("No trees.").append('\n');
        else if(ans == 1) sb.append("There is one tree.").append('\n');
        else sb.append("A forest of " + ans +" trees.").append('\n');
    }

    public static void main(String[] args) {
        int cnt = 1;
        while(true) {
            N = scan.nextInt();
            M = scan.nextInt();
            if(N == 0 && M == 0) break;
            input();
            pro(cnt++);
        }
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
