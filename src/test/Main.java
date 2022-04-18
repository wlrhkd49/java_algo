package test;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int selected[];
    static int[] nums;
    static int N, M;
    static int[] isUsed;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        selected = new int[M+1];
        isUsed = new int[N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void pro(int k) {
        if (k == M+1) {
            for(int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            int last_cand = 0;
            for (int i = 1; i <= N; i++) {
                if(isUsed[i] == 1) continue;
                if(last_cand == nums[i]) continue;

                last_cand = nums[i];
                selected[k] = nums[i]; isUsed[i] = 1;
                pro(k+1);
                selected[k] = 0; isUsed[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums, 1, N+1);
        pro(1);
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
