package 완전탐색.N과M1;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected, isUsed;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
        isUsed = new int[N+1];

        for(int i = 1; i<=N; i++) {
            isUsed[i] =  0;
        }

        String s = "1S2D*3T";
        char ch = s.toCharArray()[2];
    }

    static void pro(int k) {
        // 전체 선택 시
        if (k == M + 1) {
            for(int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for(int cand = 1; cand <= N; cand++) {
                // 사용했었는지 체크
                if(isUsed[cand] == 1) continue;

                selected[k] = cand; isUsed[cand] = 1;
                pro(k + 1);
                selected[k] = 0; isUsed[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro(1);
        System.out.println(sb.toString());
    }
}
