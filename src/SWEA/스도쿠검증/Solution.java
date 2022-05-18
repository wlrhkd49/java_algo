package SWEA.스도쿠검증;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
            int[][] a = new int[9][9];
            boolean flag = true;
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    a[i][j] = scan.nextInt();
                }
            }

            // 가로 검증
            for(int i = 0; i < 9; i++) {
                int[] visit = new int[10];
                for(int j = 0; j < 9; j++) {
                    if(visit[a[i][j]] >= 1) {
                        flag = false;
                        break;
                    }
                    visit[a[i][j]] = 1;
                }
            }

            // 세로 검증
            if(flag) {
                for (int i = 0; i < 9; i++) {
                    int[] visit = new int[10];
                    for (int j = 0; j < 9; j++) {
                        if (visit[a[j][i]] >= 1) {
                            flag = false;
                            visit = new int[10];
                            break;
                        }
                        visit[a[j][i]] = 1;
                    }
                }
            }

            // 3X3 검증
            if(flag) {
                for (int i = 0; i < 6; i += 3) {
                    for (int j = 0; j < 6; j += 3) {
                        int[] visit = new int[10];
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                if (visit[a[i + x][j + y]] >= 1) {
                                    flag = false;
                                    break;
                                }
                                visit[a[i + x][j + y]] = 1;
                            }
                        }
                    }
                }
            }

            if(flag) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
