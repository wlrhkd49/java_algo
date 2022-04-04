package exam;

import java.util.Scanner;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] dist1 = {{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3}, {1, 6, 3, 3, 0}};
    static int[][] dist = {{0, 2, 3, 1}, {2, 0, 1, 1}, {3, 1, 0, 2}, {1, 1, 2, 0}};
    static int N = dist.length;
    static long sum;
    static int[] selected = new int[N], isUsed = new int[N];

    static boolean possible(int k) {
        sum = 0;
        for(int i = 0; i < selected.length; i++) {
            int tmp = selected[i];
            if(selected[i] == -1) continue;
            if(isUsed[tmp] == 0) continue;
            sum += dist[i][k];
            if(dist[k][tmp] != sum) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int k) {
        if(k == N) {
            for(int i = 0; i < N; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for(int cand = 0; cand < N; cand++) {
                if(isUsed[cand] == 1) continue; // 이전에 사용했으면 패스
                if(possible(k)) {
                    selected[k] = cand; isUsed[cand] = 1;
                    dfs(k+1);
                    selected[k] = 0; isUsed[cand] = 0;
                }
            }
        }
    }

    public static int[][] solution(int[][] dist) {
        int[][] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        for(int i = 0; i<N; i++) {
            selected[i] = -1;
        }
        for(int i = 0; i<N; i++) {
            dfs(i);
        }
        System.out.println(sb.toString());
    }
}
