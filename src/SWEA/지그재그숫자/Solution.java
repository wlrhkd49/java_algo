package SWEA.지그재그숫자;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
            int n = scan.nextInt();
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                if(i % 2 == 1) {
                    ans += i;
                }
                else {
                    ans -= i;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
