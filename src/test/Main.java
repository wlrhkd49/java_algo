package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, C;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N+1];

        for (int i = 1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(int D) {
        int cnt = 1, last = A[1];
        // 제일 왼쪽 집부터 가능한 많이 설치
        for(int i = 2; i<=N; i++) {
            if(A[i]-last >= D) {
                cnt++;
                last = A[i];
            }
        }
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C를 비교
        return cnt >= C;
    }

    static void pro() {
        int L = 0, R = 1000000000, ans = 0;
        Arrays.sort(A, 1, N+1);
        // 이분탐색과 determination 문제를 이용하여 answer를 구하기
        while(L<=R) {
            int mid = (L+R)/2;
            if(determination(mid)) {
                ans = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
