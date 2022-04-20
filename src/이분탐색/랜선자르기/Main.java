package 이분탐색.랜선자르기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int K, N;

    static void input() {
        K = scan.nextInt();
        nums = new int[K+1];
        N = scan.nextInt();
        for(int i = 1; i <= K; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static boolean determination(long len) {
        long ans = 0;
        for(int i = 1; i <= K; i++) {
            ans += nums[i] / len;
        }
        if(ans >= N) return true;
        else return false;
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, result = 0;
        while( L <= R ) {
            long mid = (L+R)/2;
            if (determination(mid)) {
                result = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        System.out.println(result);
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