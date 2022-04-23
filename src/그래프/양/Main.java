package 그래프.양;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};
    static boolean[][] visit;
    static int L, C, wolf, sheep, totalWolf, totalSheep;
    static String[] a;

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        a = new String[L];
        for(int i = 0; i < L; i++) {
            a[i] = scan.nextLine();
        }
        visit = new boolean[L][C];
    }

    static void dfs(int x, int y) {
        if(a[x].charAt(y) == 'v') wolf++;
        if(a[x].charAt(y) == 'o') sheep++;
        visit[x][y] = true;

        for(int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || nx >= L || ny >= C) continue;
            if(visit[nx][ny]) continue;
            if(a[nx].charAt(ny) == '#') continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < C; j++) {
                if(!visit[i][j] && a[i].charAt(j) != '#') {
                    wolf = 0;
                    sheep = 0;
                    dfs(i, j);
                    if(wolf >= sheep) totalWolf += wolf;
                    else totalSheep += sheep;
                }
            }
        }
        sb.append(totalSheep).append(' ').append(totalWolf);
        System.out.println(sb);
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