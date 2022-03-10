import java.util.Scanner;

public class Ex {

    static Scanner scanner = new Scanner(System.in);

    static int N, M;

    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k) {

        if(k == M+1) {
            for(int i = 1; i<=M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }

    }

    public static void main(String[] args) {
        N = scanner.nextInt();
        M = scanner.nextInt();

        rec_func(1);
    }
}
