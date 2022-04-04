package 완전탐색.N과M9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    static int N, M;
    static int[] selected, nums, isUsed;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
        nums = new int[N+1];
        isUsed = new int[N+1];
        for (int i = 1; i<=N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void rec_func(int k) {
        if ( k == M+1 ) {
            for(int i = 1; i<=M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            int last_cand = 0;
            for(int cand = 1; cand <= N; cand++) {
                // 사용했으면 패스
                if(isUsed[cand] == 1) continue;
                // 마지막으로 사용한 cand와 같으면 패스
                if(nums[cand] == last_cand) continue;

                last_cand = nums[cand];
                selected[k] = nums[cand]; isUsed[cand] = 1;
                rec_func(k+1);
                selected[k] = 0; isUsed[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums, 1, N+1);
        rec_func(1);
        System.out.println(sb.toString());
    }
}
