package 트리.사촌;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] a, par;

    static void input() {
        a = new int[N+1];
        par = new int[N+1];
        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        par[0] = -1;
        par[1] = 0;

        int last = 1;
        for(int i = 2; i <= N; i++, last++) {
            for(; i<=N; i++) {
                par[i] = last;
                if( i < N && a[i]+1 != a[i+1]) {
                    break;
                }
            }
        }

        int kIdx = 0;
        for(int i = 1; i <= N; i++) {
            if(a[i] == K) {
                kIdx = i;
                break;
            }
        }
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(par[i] != par[kIdx] && par[par[i]] == par[par[kIdx]]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        while(true) {
            N = scan.nextInt();
            K = scan.nextInt();
            if(N == 0 && K == 0) break;
            input();
            pro();
        }
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