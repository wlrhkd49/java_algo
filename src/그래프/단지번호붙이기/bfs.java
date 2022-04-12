package 그래프.단지번호붙이기;

import java.io.*;
import java.util.*;

public class bfs {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> group;
    static int N;
    static boolean[][] visit;
    static String[] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        visit = new boolean[N][N];
        a = new String[N];
        group = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();

        Q.add(x);
        Q.add(y);
        visit[x][y] = true;
        int cnt = 0;

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            cnt++;

            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny) != '1') continue;

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
            }
        }
        group.add(cnt);
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j] && a[i].charAt(j) == '1') {
                    bfs(i,j);
                }
            }
        }

        sb.append(group.size()).append('\n');
        Collections.sort(group);
        for(int x : group) sb.append(x).append('\n');
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
