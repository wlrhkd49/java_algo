package 그래프.섬의개수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int W, H;
    static int[][] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static boolean[][] visit;

    static void input() {
        a = new int[H][W];
        visit = new boolean[H][W];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for(int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
            if(visit[nx][ny]) continue;
            if(a[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        int ans = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(!visit[i][j] && a[i][j] == 1) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while(true) {
            W = scan.nextInt();
            H = scan.nextInt();
            if( W == 0 && H == 0) break;
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