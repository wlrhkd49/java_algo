package 투포인터.ListOfUniqueNumbers;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] cnt, A;
    static FastReader scan = new FastReader();
    static int N;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        // 1 부터 10만 까지의 배열
        cnt = new int [100000 + 1];
    }

    static void pro() {
        // ans 의 타입이 long 타입임을 주의하자! -> 정답의 최대치를 계산해보기
        long ans = 0;

        for (int L=1, R=0; L<=N; L++) { // L마다 R을 최대한 옮겨 줄 계획이다.
            // R을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= N && cnt[A[R+1]] == 0) {
                R++;
                cnt[A[R]]++;
            }
            // 여기까지 오면 옮길 수 있을 만큼 옮김
            // 정답을 갱신한다.
            ans += R - L + 1;

            // L을 옮겨주면서 A[L] 의 개수를 감소시킨다.
            cnt[A[L]]--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
