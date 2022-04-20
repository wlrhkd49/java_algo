package 이분탐색.두수의합;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, X;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        nums = new int[N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        X = scan.nextInt();
    }

    static boolean binary_search(int[] nums, int L, int R, int x) {
        while(L <= R) {
            int mid = (L+R)/2;
            if(nums[mid] == x) return true;
            else if(nums[mid] > x) R = mid - 1;
            else L = mid + 1;
        }
        return false;
    }

    static void pro() {
        Arrays.sort(nums, 1, N+1);
        int cnt = 0;
        for(int i = 1; i <= N-1; i++){
            if(binary_search(nums, i+1, N, X-nums[i])) {
                cnt++;
            }
        }
        sb.append(cnt);
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
