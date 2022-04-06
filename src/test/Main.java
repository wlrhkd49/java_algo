package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] A;

    static public class Elem implements Comparable<Elem> {
        String name;
        int kor, eng, math;

        @Override
        public int compareTo(Elem o) {
            // 내림차순
            if(kor != o.kor) return o.kor - kor;
            if(eng != o.eng) return eng - o.eng;
            if(math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    static void input() {
        N = scan.nextInt();
        A = new Elem[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new Elem();
            A[i].name = scan.next();
            A[i].kor = scan.nextInt();
            A[i].eng = scan.nextInt();
            A[i].math = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N+1);

        for (int i = 1; i <= N; i++) {
            sb.append(A[i].name).append('\n');
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
