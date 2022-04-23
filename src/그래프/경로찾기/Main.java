package 그래프.경로찾기;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] a;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        a = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        visit = new boolean[N];
    }

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i < N; i++) visit[i] = false;

        Q.add(start);
        visit[start] = false; // 다시 돌아올 수 있는지 확인 필요

        while(!Q.isEmpty()) {
            int x = Q.poll();

            for(int y = 0; y < N; y++) {
                if(visit[y]) continue;
                if(a[x][y] == 0) continue;
                Q.add(y);
                visit[y] = true;
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(visit[i] ? 1 : 0).append(' ');
        }
        sb.append('\n');
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            bfs(i);
        }
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