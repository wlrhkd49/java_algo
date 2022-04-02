package 그래프.미로탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2178
public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[][] dist;
    static boolean[][] visit;
    static int N, M;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;
    static String[] a;
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.next();
        visit = new boolean[N][M];
        dist = new int[N][M];
    }

    // x, y를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        // dist 배열 초기화
        for (int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                dist[i][j] = -1;
            }
        }

        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        // BFS 과정 시작
        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(a[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                // dist 값을 새로 갱신
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        // 시작점이 (0,0)인 탐색 시작
        bfs(0, 0);

        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        System.out.println(dist[N-1][M-1]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
