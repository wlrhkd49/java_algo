package 투포인터.귀여운라이언;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] infos;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        infos = new int[N+1];
        for(int i = 1; i <= N; i++) {
            infos[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, cnt = 0, ans = Integer.MAX_VALUE;
        for(int L = 1; L <= N; L++) {
            // 이전 값이 1(라이언)이면 제거
            if(infos[L - 1] == 1) {
                cnt--;
            }

            while(R + 1 <= N && cnt < K) {
                if(infos[++R] == 1) {
                    cnt++;
                }
            }
            if(cnt == K) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
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
