package SWEA.시각덧셈;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
            int h1 = scan.nextInt(), m1 = scan.nextInt();
            int h2 = scan.nextInt(), m2 = scan.nextInt();

            int hour = (h1 + h2) % 12;
            int minite = 0;
            if(((m1 + m2) / 60) == 1) {
                hour++;
                hour = hour % 12;
                minite = (m1 + m2)%60;
            }
            else {
                minite = m1 + m2;
            }
            sb.append(hour==0 ? 12 : hour).append(" ").append(minite).append("\n");
        }
        System.out.println(sb);
    }
}

