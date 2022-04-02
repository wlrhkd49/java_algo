package 완전탐색.N과M3;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int N, M;

    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k) {

        if(k == M+1) {
            for(int i = 1; i<=M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for(int i = 1; i<=N; i++) {
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
            }
        }

    }

    public static void main(String[] args) {
        N = scanner.nextInt();
        M = scanner.nextInt();
        selected = new int[M+1];

        rec_func(1);
        System.out.println(sb);
    }
}
