package 이분탐색.공유기설치;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] A;

    static void input() {
        N = sc.nextInt();
        C = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(int D) {
        // D만큼의 거리 차이를 둔다면 C개 만큼의 공유기를 설치할 수 있는가?

        // 제일 왼쪽 집부터 가능한 많이 설치해보자
        // D만큼의 거리를 두면서 최대로 설치한 개수와 C를 비교하자.
        int cnt = 1, last = A[1];
        for(int i = 2; i<=N; i++) {
            // 이번에 A[i]에 설치가 가능한가?
            if(A[i] - last >= D) {
                cnt++;
                last = A[i];
            }
        }
        return cnt >= C;
    }

    static void pro() {
        // determination을 빠르게 하기 위해서 정렬
        Arrays.sort(A, 1, N+1);

        int L = 1, R = 1000000000, ans = 0;

        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L<=R) {
            int mid = (L+R)/2;
            if(determination(mid)) {
                ans = mid;
                L = mid + 1; // 지금보다 작은 위치 무시
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
