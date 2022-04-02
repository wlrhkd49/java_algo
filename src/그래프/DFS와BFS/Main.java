package 그래프.DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1260
// 인접행렬 이용
public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    // N: vertex, M: edges,
    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N+1][N+1];

        // 간선 입력받고 인접행렬에 1 초기화
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        // 방문처리하기
        for(int y=1; y<=N; y++) {
            // 간선이 없으면 패스
            if(adj[x][y] == 0) continue;
            // 이미 방문한 노드면 패스
            if(visit[y] == true) continue;

            // 계속 찾기
            dfs(y);
        }
    }

    static void bfs(int start) {
        // 선입선출
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()) {
            int x = que.poll(); // 큐에서 원소 뽑음
            sb.append(x).append(' ');

            // 해당 노드에 인접한 노드들 큐에 넣어줌
            for (int y=1; y<=N; y++) {
                // 간선이 없으면 패스
                if(adj[x][y] == 0) continue;
                // 이미 방문했으면 패스
                if(visit[y] == true) continue;

                // 큐에 넣어줌
                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        // 새로운 탐색을 위해 visit 배열 초기화
        for(int i = 1; i<=N; i++) visit[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
