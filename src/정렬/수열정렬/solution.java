package 정렬.수열정렬;

import java.util.Arrays;
import java.util.Scanner;

//1015
public class solution {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        // idx : A 배열의 위치, num : A[idx]의 원래 값
        public int num, idx;

        @Override
        public int compareTo(Elem o) {
            // num 오름차순 정렬
            return num - o.num;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() {
        N = sc.nextInt();
        B = new Elem[N];
        P = new int[N];
        for(int i = 0; i < N; i++) {
            B[i] = new Elem();
            // Elem의 정의에 맞게 B[i]에 값을 넣어주기
            B[i].num = sc.nextInt();
            // 기존 A 배열의 인덱스 위치
            B[i].idx = i;
        }
    }

    static void pro() {
        // B 배열 정렬하기
        Arrays.sort(B);

        // B 배열의 값을 이용해서 P 배열 채우기
        for(int b_idx = 0; b_idx < N; b_idx++) {
            // 낮은 위치부터 찾기
            P[B[b_idx].idx] = b_idx;
        }

        // P 배열 출력하기
        for(int i = 0; i<N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
