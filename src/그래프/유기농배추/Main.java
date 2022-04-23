package 그래프.유기농배추;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int M, N, K;
    static int[][] adj;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        adj = new int[M][N];
        visit = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y] = 1;
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for(int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(adj[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        int ans = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(adj[i][j] == 1 && !visit[i][j]) {
                    ans++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = scan.nextInt();
        for(int i = 0; i < t; i ++) {
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

