package 완전탐색.N과M2;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;
    static boolean isUsed;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
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
            for(int cand = selected[k-1] + 1; cand <= N; cand++) {
                // 사용안했으면 select 배열에 추가
                selected[k] = cand;
                pro(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro(1);
        System.out.println(sb.toString());
    }
}