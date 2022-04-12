package test;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, B, ans;
    static boolean[][] visit;
    static int[][] a, blank;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N][M];
        blank = new int[N * M + 1][2];
        visit = new boolean[N][M];
        ans = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    // 바이러스 전파
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visit[i][j] = false;
                if(a[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(a[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
            }
        }

        // 탐색 종료후 안전 개수 찾기
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(a[i][j] == 0 && !visit[i][j]) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    // 벽 3개 세우기
    static void dfs(int idx, int selected_cnt) {
        if(selected_cnt == 3) {
            bfs();
            return;
        }
        if(idx > B) return;

        // 벽 세움
        a[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);

        a[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(a[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        dfs(1, 0);
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
