package 그래프.탈출;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist_water, dist_hedgehog;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    // 모든 물통을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> Q = new LinkedList<>();
        // 모든 물의 위치를 큐에 넣어주자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_water 와 visit 배열 초기화
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if(a[i].charAt(j) == '*') {
                    Q.add(i);
                    Q.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
            //BFS 시작
            while(!Q.isEmpty()) {
                int x = Q.poll();
                int y = Q.poll();
                for(int k =0; k<4; k++) {
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(a[nx].charAt(ny) != '.') continue;
                    if(visit[nx][ny])  continue;
                    visit[nx][ny] = true;
                    dist_water[nx][ny] = dist_water[x][y] + 1;
                    Q.add(nx);
                    Q.add(ny);
                }
            }
        }

    }

    public static void main(String[] args) {

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
