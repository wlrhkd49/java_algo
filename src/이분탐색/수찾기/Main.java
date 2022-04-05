package 이분탐색.수찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] find, want;

    static void input() {
        N = scan.nextInt();
        find = new int[N+1];
        for (int i = 1; i<=N; i++) {
            find[i] = scan.nextInt();
        }
        M = scan.nextInt();
        want = new int[M+1];
        for (int i = 1; i<=M; i++) {
            want[i] = scan.nextInt();
        }
    }

    static boolean binary_search(int[] find, int L, int R, int X) {
        boolean isPresent = false;

        while(L<=R) {
            int mid = (L+R) / 2;
            if(find[mid] == X) return true;
            else if(find[mid] > X) {
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return isPresent;
    }

    static void pro() {
        Arrays.sort(find, 1, N+1);
        for(int i = 1; i<=M; i++) {
            if(binary_search(find, 1, N, want[i])) {
                System.out.println('1');
            }
            else {
                System.out.println('0');
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
