package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] A;

    static void input() {
        N = scan.nextInt();
        A = new long[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLong();
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N+1);

        int curCnt = 1, modeCnt = 1;
        long mode = A[1];
        for (int i = 2; i <= N; i++) {
            if(A[i-1] == A[i]) {
                curCnt++;
                if(curCnt > modeCnt) {
                    mode = A[i];
                    modeCnt = curCnt;
                }
            }
            else {
                curCnt = 1;
            }
        }
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
