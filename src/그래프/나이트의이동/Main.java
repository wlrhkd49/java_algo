package 그래프.나이트의이동;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    static int[][] dist;
    static int N, start_x, start_y, dest_x, dest_y;
    static boolean[][] visit;

    static void input() {
        N = scan.nextInt();
        dist = new int[N][N];
        visit = new boolean[N][N];
        start_x = scan.nextInt();
        start_y = scan.nextInt();
        dest_x = scan.nextInt();
        dest_y = scan.nextInt();
    }

    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x); Q.add(y);
        visit[x][y] = true;

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for(int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;

                Q.add(nx); Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(start_x, start_y);
        System.out.println(dist[dest_x][dest_y]);
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
