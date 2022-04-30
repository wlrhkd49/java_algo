package 트리.트리2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, edge_cnt, vertex_cnt;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

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
            // 정점 개수 증가
            vertex_cnt++;
            // 인접한 정점의 개수 더하기
            edge_cnt += adj[x].size();
            visit[x] = true;

            for(int y : adj[x]) {
                if(visit[y]) continue;
                Q.add(y);
            }
        }
    }

    static void pro(int t) {
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            vertex_cnt = 0;
            edge_cnt = 0;
            bfs(i);
            // 정점이 n개면 간선은 n-1개
            if(edge_cnt == (vertex_cnt - 1) * 2) ans++;
        }

        sb.append("Case ").append(t).append(": ");
        if(ans == 0) sb.append("No trees.").append('\n');
        else if(ans == 1) sb.append("There is one tree.").append('\n');
        else sb.append("A forest of ").append(ans).append(" trees.").append('\n');

    }

    public static void main(String[] args) {
        int t = 1;
        while(true) {
            N = scan.nextInt();
            M = scan.nextInt();

            if( N == 0 && M == 0 ) break;

            input();
            pro(t++);
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