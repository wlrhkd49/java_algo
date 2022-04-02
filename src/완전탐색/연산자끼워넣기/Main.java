package 완전탐색.연산자끼워넣기;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Integer max, min;
    static int[] nums, operators, order;

    static void input() {
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N+1];
        for(int i = 1; i<=N; i++) nums[i] = scan.nextInt();
        for(int i = 1; i<=4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int calculator(int x1, int operator ,int x2) {
        if(operator == 1) {
            return x1 + x2;
        }
        else if(operator == 2) {
            return x1 - x2;
        }
        else if(operator == 3) {
            return x1 * x2;
        }
        else {
            return x1 / x2;
        }
    }

    static void pro(int k, int value) {
        if( k == N ) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        else {
            for(int cand = 1; cand <= 4; cand++) {
                if(operators[cand] >= 1) {
                    operators[cand]--;
                    pro(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }
}
