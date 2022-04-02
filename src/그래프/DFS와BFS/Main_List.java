package 그래프.DFS와BFS;

import java.util.*;

// 1260
// 인접리스트 이용
public class Main_List {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            // 노드에 인접리스트 생성해주기
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i=1; i<=N; i++) {
            // 정렬해서 작은순서대로 들어갈 수 있도록 함
            Collections.sort(adj[i]);
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for(int y : adj[x]) {
            if(visit[y] == true) continue;
            dfs(y);
        }
    }

    static void dfs1(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for(int y : adj[x]) {
            if(visit[y]) continue;

            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()) {
            int x = que.poll(); // 큐에서 원소 뽑음
            sb.append(x).append(' ');
            for (int y : adj[x]) {
                if(visit[y] == true) continue;

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
