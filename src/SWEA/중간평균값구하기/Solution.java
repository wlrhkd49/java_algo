package SWEA.중간평균값구하기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
            int[] a = new int[11];
            for(int i = 1; i <= 10; i++) {
                a[i] = scan.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= 10; i++) {
                if(a[i] > max) max = a[i];
                if(a[i] < min) min = a[i];
            }
            int ans = 0;
            for(int i = 1; i <= 10; i++) {
                if(a[i] == max) continue;
                if(a[i] == min) continue;
                ans += a[i];
            }
            sb.append(Math.round((double)ans/8)).append("\n");
        }
        System.out.println(sb);
    }
}
