package 완전탐색.암호만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] alpha;
    static int[] selected;

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        alpha = new char[C+1];
        selected = new int[L+1];
        for(int i = 1; i<=C; i++) {
            alpha[i] = scan.next().charAt(0);
        }
    }

    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    static void rec_func(int k) {
        if(k == L+1) {
            int vowel = 0, consonant = 0;
            for(int i = 1; i<=L; i++) {
                if(isVowel(alpha[selected[i]])) vowel++;
                else consonant++;
            }
            if(vowel>=1 && consonant>=2) {
                for(int i = 1; i<=L; i++) sb.append(alpha[selected[i]]);
                sb.append('\n');
            }
        }
        else {
            for(int cand = selected[k-1]+1; cand<=C; cand++) {
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(alpha, 1, C+1);
        rec_func(1);
        System.out.println(sb.toString());
    }
}
