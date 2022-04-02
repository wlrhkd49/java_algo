package 그래프.단지번호붙이기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    // 방향을 위한 배열
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for(int i=0; i < N; i++) {
            // 한 줄당 문자열 입력
            a[i] = scan.next();
        }
        // 방문정보 저장
        visit = new boolean[N][N];
    }

    // x, y를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visit 체크하기
        group_cnt++;
        visit[x][y] = true;

        // 인접한 집으로 새로운 방문하기
        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            // 이 위치에 집이 있는지, 방문했는지

            // 집 없는 경우
            if(a[nx].charAt(ny) == '0') continue;
            // 방문했던 집인 경우
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        // 단지를 찾을때마다 단지 정보 기록 배열
        group = new ArrayList<>();
        // 한 칸씩 조회
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 갈 수 있는 칸인데, 이미 방문처리 된, 즉 새롭게 만난 단지인 경우!
                if(!visit[i][j] && a[i].charAt(j) =='1') {
                    // 그 그룹의 개수
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for(int cnt:group) sb.append(cnt).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
