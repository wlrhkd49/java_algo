package 그래프.케빈베이컨의6단계법칙;

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
    static boolean[] visit;
    static int[][] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        visit = new boolean[N+1];
        dist = new int[N+1][N+1];
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
        for(int i = 1; i <= N; i++) visit[i] = false;
        Q.add(start);
        visit[start] = true;

        while(!Q.isEmpty()) {
            int x = Q.poll();

            for(int y : adj[x]) {
                if(visit[y]) continue;
                dist[start][y] = dist[start][x] + 1;
                visit[y] = true;
                Q.add(y);
            }
        }
    }

    static void pro() {
        for(int i = 1; i <= N; i++) {
            bfs(i);
        }

        int[] sum = new int[N+1];
        for(int i = 1; i <= N; i++) {
            int ans = 0;
            for(int j = 1; j <= N; j++) {
                ans += dist[i][j];
            }
            sum[i] = ans;
        }

        int answer = Integer.MAX_VALUE, ans = 0;
        for(int i = 1; i <= N; i++) {
            if(answer > sum[i]) {
                answer = sum[i];
                ans = i;
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
