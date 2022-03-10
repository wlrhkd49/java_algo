package 정렬.카드;

import java.util.Arrays;
import java.util.Scanner;

// 11652
public class Main {
    // 최대치가 크므로 long 사용
    static Scanner sc = new Scanner(System.in);

    static int N;
    static long[] a;

    static void input() {
        N = sc.nextInt();
        a = new long[N + 1];
        for(int i=1; i<=N; i++) {
            a[i] = sc.nextLong();
        }
    }

    static void pro() {
        // Sort 정렬하기
        Arrays.sort(a, 1, N+1);

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는 지를 판단하여 갱신
        for(int i = 2; i <= N; i++) {
            // 이전과 같다면
            if(a[i-1] == a[i]) {
                curCnt++;
            }
            // 이전과 다르다면 초기화
            else {
                curCnt = 1;
            }
            // 최빈값이 높으면 mode 갱신
            if(modeCnt < curCnt) {
                mode = a[i];
                modeCnt = curCnt;
            }
        }

        // 정답 출력하기
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
