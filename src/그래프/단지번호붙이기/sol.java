package 그래프.단지번호붙이기;

import java.util.ArrayList;
import java.util.Scanner;

public class sol {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static String[] a;
    static boolean[][] visit;
    static ArrayList<Integer> group = new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for(int i = 0; i<N; i++) {
            a[i] = scan.next();
        }
        visit = new boolean[N][N];
    }

    static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visit[nx][ny]) continue;
            if(a[nx].charAt(ny) == '0') continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i<N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }
        sb.append(group.size()).append('\n');
        for(int cnt : group) sb.append(cnt).append('\n');

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
