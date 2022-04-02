package 이분탐색.듣보잡;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static String[] A, ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N+1];
        for(int i = 1; i<=N; i++) {
            A[i] = scan.next();
        }
    }

    static void pro() {
        int ansCnt = 0;
        ans = new String[N+1];
        Arrays.sort(A, 1, N+1);
        for(int i = 1; i <= M; i++) {
            String X = scan.next();
            if(bin_search(A, 1, N, X)) ans[++ansCnt] = X;
        }
        Arrays.sort(ans, 1, ansCnt + 1);
        sb.append(ansCnt).append('\n');
        for(int i = 1; i <= ansCnt; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }

    static boolean bin_search(String[] A, int L, int R, String X) {
        while(L<=R) {
            int mid = (L + R) / 2;
            if(A[mid].equals(X)) {
                return true;
            }

            if(A[mid].compareTo(X) < 0) {
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
