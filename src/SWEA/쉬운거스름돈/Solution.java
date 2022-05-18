package SWEA.쉬운거스름돈;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +"\n" );
            int x = scan.nextInt();
            // 50000원
            if(x / 50000 >= 1) {
                sb.append(x/50000).append(" ");
                x %= 50000;
            }
            else {
                sb.append(0).append(" ");
            }
            // 10000원
            if(x / 10000 >= 1) {
                sb.append(x/10000).append(" ");
                x %= 10000;
            }
            else {
                sb.append(0).append(" ");
            }
            // 5000원
            if(x / 5000 >= 1) {
                sb.append(x/5000).append(" ");
                x %= 5000;
            }
            else {
                sb.append(0).append(" ");
            }
            // 1000원
            if(x / 1000 >= 1) {
                sb.append(x/1000).append(" ");
                x %= 1000;
            }
            else {
                sb.append(0).append(" ");
            }
            // 500원
            if(x / 500 >= 1) {
                sb.append(x/500).append(" ");
                x %= 500;
            }
            else {
                sb.append(0).append(" ");
            }
            // 100원
            if(x / 100 >= 1) {
                sb.append(x/100).append(" ");
                x %= 100;
            }
            else {
                sb.append(0).append(" ");
            }
            // 50원
            if(x / 50 >= 1) {
                sb.append(x/50).append(" ");
                x %= 50;
            }
            else {
                sb.append(0).append(" ");
            }
            // 10원
            if(x / 10 >= 1) {
                sb.append(x/10).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }

        }
        System.out.println(sb);
    }
}
