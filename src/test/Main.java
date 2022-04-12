package test;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
    static ArrayList<Integer> group;
    static int N;
    static boolean[][] visit;
    static String[] a;
=======
    static int N, group_cnt;
    static ArrayList<Integer> group;
    static String[] a;
    static boolean[][] visit;
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
<<<<<<< HEAD
        visit = new boolean[N][N];
        a = new String[N];
        group = new ArrayList<>();
=======
        a = new String[N];
        group = new ArrayList<>();
        visit = new boolean[N][N];
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e

        for(int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }

<<<<<<< HEAD
    static void bfs(int x, int y) {
=======
    static void BFS(int x, int y) {
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e
        Queue<Integer> Q = new LinkedList<>();

        Q.add(x);
        Q.add(y);
        visit[x][y] = true;
<<<<<<< HEAD
        int cnt = 0;
=======
        group_cnt++;
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
<<<<<<< HEAD
            cnt++;
=======
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e

            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;
<<<<<<< HEAD
                if(a[nx].charAt(ny) != '1') continue;
=======
                if(a[nx].charAt(ny) == '0') continue;
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
<<<<<<< HEAD
            }
        }
        group.add(cnt);
=======
                group_cnt++;
            }
        }
        group.add(group_cnt);

>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
<<<<<<< HEAD
            for(int j = 0; j < N; j++) {
                if(!visit[i][j] && a[i].charAt(j) == '1') {
                    bfs(i,j);
=======
            for (int j = 0; j < N; j ++) {
                if(!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    BFS(i, j);
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e
                }
            }
        }

<<<<<<< HEAD
        sb.append(group.size()).append('\n');
        Collections.sort(group);
        for(int x : group) sb.append(x).append('\n');
=======
        // 출력결과 정렬하기
        sb.append(group.size()).append('\n');
        Collections.sort(group);
        for(int i = 0; i < group.size(); i++){
            sb.append(group.get(i)).append('\n');
        }
>>>>>>> 3b4acf12775f58fd5525c5528216349549d43f3e
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
