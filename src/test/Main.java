package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+1];
        B = new int[M+1];
        for(int i = 1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
        for(int i = 1; i<=M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        int result = L-1;

        while(L<=R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                R = mid - 1;
            } else {
                result = mid;
                L = mid + 1;
            }
        }
        return result;
    }

    static void pro() {
        Arrays.sort(B, 1, M+1);

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int tt = scan.nextInt();
        for(int i = 0; i<tt; i++) {
            input();
            pro();
        }
    }
}
