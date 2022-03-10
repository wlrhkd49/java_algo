import java.util.Scanner;

public class solution7 {
    static int N, ans;
    static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N+1];
    }

    static boolean validity_check() {
        for(int i = 1; i<=N; i++) {
            // (i, col[i]) i행, col[i]열
            for(int j=1; j<i; j++) {
                // (j, col[j])
                if(attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        // 같은 열 경우 공격 가능
        if(c1==c2 ) return true;
        // 오른쪽 위 대각선이 같은 경우 공격 가능
        if(r1+c1 == r2+c2) return true;
        // 왼쪽 위 대각선이 같은 경우 공격 가능
        if(r1-c1 == r2-c2) return true;
        return false;
    }

    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    static void rec_func(int row) {
        if (row == N + 1) { // 각 행마다 모두 잘 놓았다.
            if(validity_check()) { // 서로 공격하는 퀸들이 없는 경우
                ans++;
            }
        }
        else {
            for (int c = 1; c <= N; c++) {
                col[row] = c; //col에 row번째가 c다.
                rec_func(row + 1);
                col[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}