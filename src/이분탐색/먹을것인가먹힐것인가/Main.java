package 이분탐색.먹을것인가먹힐것인가;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static int N, M;
    static int[] B;
    static int[] A;

    // 이분 탐색
    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R]에서 X 미만의 수 중 제일 오른쪽 인덱스를 리턴하는 함수
        // 그런 게 없다면 L - 1을 리턴한다.
        int result = L - 1;

        while( L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] >= X) { // 찾고자 하는 값이 작은 경우
                R = mid - 1;
            }
            else { // 찾고자 하는 값이 큰 경우 (배열의 오른쪽만 확인)
                result = mid;
                L = mid + 1;
            }
        }

        return result;
    }

    static void pro() {
        // B배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(B, 1, M+1);

        int ans = 0;
        for (int i = 1; i<=N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }

        System.out.println(ans);
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        int TT;
        TT = scan.nextInt();
        for(int tt = 1; tt <= TT; tt++) {
            input();
            pro();
        }
    }
}
