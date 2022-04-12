package 투포인터.부분합;

import java.util.Scanner;

// 1806
public class Main {
    static int n, S;
    static int [] a;
    static Scanner scan = new Scanner(System.in);

    static void input() {
        n = scan.nextInt();
        S = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = n + 1;
        for (int L = 1; L <= n; L++) {
            // L - 1 을 구간에서 제외하기
            sum -= a[L - 1];
            // R 을 옮길 수 있을 때 까지 옮기기
            // 합이 S를 넘으면 옮길 필요 없음
            while(R + 1 <= n && sum < S) {
                R++;
                sum += a[R];
            }

            // [L...R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if(sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }

        // ans 값을 보고 불가능 판단하기 (한번도 값이 갱신 안됐다면)
        if (ans == n + 1) {
            ans = 0;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
