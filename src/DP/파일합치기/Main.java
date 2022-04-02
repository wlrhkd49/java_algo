package DP.파일합치기;

import java.io.*;
import java.util.StringTokenizer;

// 11066
public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K;
    static int[] num;
    static int[][] sum;
    static int[][] Dy;

    static void input() {
        K = scan.nextInt();
        num = new int[K + 1];
        sum = new int[K + 1][K + 1];
        for(int i = 1; i<=K; i++) {
            num[i] = scan.nextInt();
        }
    }

    static void process() {
        for(int i = 1; i<=K; i++) {
            for(int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j-1] + num[j];
            }
        }
    }

    static void pro() {
        process();
        Dy = new int[K+1][K+1];

        for (int len = 2; len <= K; len++) {
            for(int i = 1; i<=K-len+1; i++) {
                int j = i + len - 1; // 구간이 끝나는 위치
                Dy[i][j] = Integer.MAX_VALUE; // 초기에는 크게 설정

                for(int k = i; k < j; k++) {
                    // 지금까지 최소값과 k 위치까지의 최솟값을 설정
                    Dy[i][j] = Math.min(
                            Dy[i][j],
                            Dy[i][k] + Dy[k+1][j] + sum[i][j]
                    );
                }
            }
        }

        System.out.println(Dy[1][K]);
    }

    public static void main(String[] args) {
        int tt = scan.nextInt();
        for(int i = 0; i<tt; i++){
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