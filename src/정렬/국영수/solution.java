package 정렬.국영수;

import java.util.Arrays;
import java.util.Scanner;

//10825
public class solution {
    static int N;
    static Elem[] a;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem o) {
            // 국어 점수 내림차순
            if(korean != o.korean) return o.korean - korean;
            // 영어 점수 오름차순
            if(english != o.english) return english - o.english;
            // 수학 내림차순
            if(math != o.math) return o.math - math;
            // 이름순으로 정렬
            return name.compareTo(o.name);
        }
    }

    static void input() {
        N = sc.nextInt();
        a = new Elem[N];
        for( int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = sc.next();
            a[i].korean = sc.nextInt();
            a[i].english = sc.nextInt();
            a[i].math = sc.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(a);

        for(int i=0; i<a.length; i++) {
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }


}
