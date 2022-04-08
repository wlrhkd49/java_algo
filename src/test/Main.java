package test;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N+1];
        visit = new boolean[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++) {
            A[i] = scan.next();
        }
    }

    static void bfs(int x, int y) {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> Q = new LinkedList<>();

        Q.add(x);
        Q.add(y);
        visit[x][y] = true;
        dist[x][y] = 1;

        while(!Q.isEmpty()) {
            int _x = Q.poll();
            int _y = Q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = _x + dir[i][0];
                int ny = _y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(A[nx].charAt(ny) == '0') continue;

                visit[nx][ny] = true;
                dist[nx][ny] = dist[_x][_y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void pro() {
        bfs(0, 0);

        System.out.println(dist[N-1][M-1]);
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
