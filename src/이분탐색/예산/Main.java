package 이분탐색.예산;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        nums = new int[N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static boolean determination(long x) {
        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(nums[i] <= x) {
                result += nums[i];
            }
            else {
                result += x;
            }
        }
        return result <= M;
    }

    static void pro() {
        long L = 1, R = 0, ans = 0;
        for(int i = 1; i <= N; i++) R = Math.max(R, nums[i]);
        while(L<=R) {
            long mid = (L+R)/2;
            if(determination(mid)) {
                ans = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
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