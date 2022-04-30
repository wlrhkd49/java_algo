package 그래프.토마토;


import java.beans.Visibility;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, H;
    static int[][] dir = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
    static int[][][] a;
    static int[][][] dist;

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        a = new int[H][N][M];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    a[i][j][k] = scan.nextInt();
                }
            }
        }
        dist = new int[H][N][M];
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(a[i][j][k] == 1) {
                        Q.add(i);
                        Q.add(j);
                        Q.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while(!Q.isEmpty()) {
            int h = Q.poll();
            int x = Q.poll();
            int y = Q.poll();

            for(int k = 0; k < 6; k++) {
                int nh = h + dir[k][0];
                int nx = x + dir[k][1];
                int ny = y + dir[k][2];

                if(nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M) continue;
                if(a[nh][nx][ny] == -1) continue;
                if(dist[nh][nx][ny] != -1) continue;

                Q.add(nh);
                Q.add(nx);
                Q.add(ny);
                dist[nh][nx][ny] = dist[h][x][y] + 1;
            }
        }
    }

    static int pro() {
        int ans = 0;
        bfs();
        boolean alreadyGood = true;
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(a[i][j][k] == 1) continue;
                    if(dist[i][j][k] == -1 && a[i][j][k] != -1) return -1;
                    if(dist[i][j][k] >= 1) {
                        alreadyGood = false;
                    }
                    if(ans < dist[i][j][k]) {
                        ans = dist[i][j][k];
                    }
                }
            }
        }
        if (alreadyGood) return 0;
        else return ans;
    }

    public static void main(String[] args) {
        input();
        System.out.println(pro());
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
