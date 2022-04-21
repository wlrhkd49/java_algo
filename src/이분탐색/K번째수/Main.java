package 이분탐색.K번째수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static boolean determination(long n) {
        // n 보다 작거나 같은 원소의 개수 합이 K개 이상인가?
        long sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += Math.min(N, n / i);
        }
        return sum >= K;
    }

    static void pro() {
        // B[K] = x 에서 x 값을 조정하면서 x보다 작거나 같은 원소의 개수가 K값이랑 일치 하는 지 확인
        long L = 1, R = (long)N * N, ans = 0;
        while(L <= R) {
            long mid = ( L + R ) / 2;
            if(determination(mid)) {
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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

