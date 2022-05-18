package SWEA.어디에단어가들어갈수있을가;

import jdk.swing.interop.DropTargetContextWrapper;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            int N = scan.nextInt(), K = scan.nextInt();
            sb.append("#" + t +" " );
            int[][] a = new int[N][N];
            int ans = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    a[i][j] = scan.nextInt();
                }
            }

            // 가로 체크
            for(int i = 0; i < N; i++){
                int colCheck = 0;
                for(int j = 0; j < N; j++) {
                    if(a[i][j] == 0) {
                        if(colCheck == K) ans++;
                        colCheck = 0;
                    }
                    else {
                        colCheck++;
                    }
                }
                if(colCheck == K) ans++;
            }

            // 세로 체크
            for(int i = 0; i < N; i++) {
                int rowCheck = 0;
                for(int j = 0; j < N; j++) {
                    if(a[j][i] == 0) {
                        if(rowCheck == K) ans++;
                        rowCheck = 0;
                    }
                    else {
                        rowCheck++;
                    }
                }
                if(rowCheck == K) ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
