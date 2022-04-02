package DP.트리와쿼리;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 15681
public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Dy;
    static int N, R, Q;
    static ArrayList<Integer>[] con;

    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        con = new ArrayList[N+1];
        for (int i = 1; i<=N; i++) {
            con[i] = new ArrayList<>();
        }
        for(int i = 1; i<N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    // Dy[x] 를 계산하는 함수
    static void dfs(int x, int prev) {
        Dy[x] = 1; // 나는 무조건 포함
        for (int y : con[x]) {
            if(y == prev) continue; // 부모는 제거
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }

    static void pro() {
        Dy = new int[N+1];

        dfs(R, -1);

        for(int i = 1; i <= Q; i++) {
            int q = scan.nextInt();
            sb.append(Dy[q]).append('\n');
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