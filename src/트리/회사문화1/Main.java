package 트리.회사문화1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] par;
    static int[] score;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        score = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            int x = scan.nextInt();
            if( i == 1 ) continue;
            adj[x].add(i);
        }
    }

    static void dfs(int x) {
        for(int y : adj[x]) {
            score[y] += score[x];
            dfs(y);
        }
    }

    static void pro() {
        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt(), point = scan.nextInt();
            score[x] += point;
        }

        dfs(1);
        for(int i = 1; i <= N; i++) {
            sb.append(score[i]).append(' ');
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
