package 완전탐색.NQueen;

import java.util.Scanner;

// 9663
public class Main {
    static Scanner scan = new Scanner(System.in);
    static int N;
    static int ans;
    static int[] col;

    static void input() {
        N = scan.nextInt();
        ans = 0;
        col = new int[N+1];
    }

    static void pro(int row) {
        if(row == N+1) {
            ans++;
        }
        else {
            for(int c = 1; c <= N; c++){
                boolean isOk = true;
                for(int i = 1; i<=row-1; i++) {
                    if(attackable(row, c, i, col[i])) {
                        isOk = false;
                        // 이 이상의 확인 작업을 중지
                        break;
                    }
                }
                if(isOk) {
                    // 배치 가능하므로 배치
                    col[row] = c;
                    pro(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        else if(r1+c1 == r2+c2) return true;
        else if(r1-c1 == r2-c2) return true;
        else return false;
    }

    public static void main(String[] args) {
        input();
        pro(1);
        System.out.println(ans);
    }

}
