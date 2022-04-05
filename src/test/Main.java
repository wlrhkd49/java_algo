package test;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] A;

    static void input() {
        N = scan.nextInt();
        A = new long[N];
        for(int i = 0; i < N; i++) {
            A[i] = scan.nextLong();
        }
    }

    static void pro() {
        // A 정렬
        Arrays.sort(A);

        int curCnt = 1, modeCnt = 1;
        long mode = A[0];
        long last = A[0];

        for(int i = 1; i < N; i++) {
            if(last == A[i]) {
                curCnt++;
                if(curCnt > modeCnt) {
                    modeCnt = curCnt;
                    mode = A[i];
                }
            }
            else {
                curCnt = 1;
                last = A[i];
            }
        }
        sb.append(mode);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
