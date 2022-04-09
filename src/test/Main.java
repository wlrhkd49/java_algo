package test;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;
    static ArrayList<Integer> group;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        group = new ArrayList<>();
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }

    static void BFS(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();

        Q.add(x);
        Q.add(y);
        visit[x][y] = true;
        group_cnt++;

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;
                if(a[nx].charAt(ny) == '0') continue;

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                group_cnt++;
            }
        }
        group.add(group_cnt);

    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j ++) {
                if(!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    BFS(i, j);
                }
            }
        }

        // 출력결과 정렬하기
        sb.append(group.size()).append('\n');
        Collections.sort(group);
        for(int i = 0; i < group.size(); i++){
            sb.append(group.get(i)).append('\n');
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
