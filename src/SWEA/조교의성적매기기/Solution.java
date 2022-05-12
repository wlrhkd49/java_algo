package SWEA.조교의성적매기기;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
            int n = scan.nextInt();
            int k = scan.nextInt();
            Double[] student = new Double[n];
            double k_sum = 0;
            for(int i = 0; i < n; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                int c = scan.nextInt();
                double sum = a * 0.35 + b * 0.45 + c * 0.20;
                if(i+1 == k) {
                    k_sum = sum;
                }
                student[i] = sum;
            }
            Arrays.sort(student, Collections.reverseOrder());

            int idx = 0;
            for(int i = 0; i < n; i++) {
                if(student[i] == k_sum) {
                    idx = i;
                }
            }

            sb.append(score[idx/(n/10)]).append("\n");
        }
        System.out.println(sb);
    }
}
