package SWEA.초심자의회문검사;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
            char[] s = scan.next().toCharArray();
            int n = s.length;
            boolean flag = true;
            for(int i = 0; i < n/2; i++) {
                if(s[i] != s[n-i-1]) flag=false;
                break;
            }
            if(flag) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
