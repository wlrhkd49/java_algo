package test;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int H) {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            if(A[i] - H > 0) {
                sum += A[i] - H;
            }
        }

        if(sum >= M) {
            return true;
        }
        else {
            return false;
        }
    }

    static void pro() {
        int L = 0, R = 2000000000, result = 0;
        while(L<=R) {
            int mid = (L+R)/2;
            if(determination(mid)) {
                result = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
