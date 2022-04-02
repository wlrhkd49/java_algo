package 이분탐색.나무자르기;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int N, M;
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        for(int i = 1; i<=N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 리턴하는 함수
        long sum = 0; // 자른 나무의 총 길이

        for(int i = 1; i<=N; i++) {
            if(A[i] > H) {
                sum += A[i] - H;
            }
        }

        if (sum >= M) {
            return true;
        }
        else {
            return false;
        }
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L <= R) {
            int mid = (int)((L+R)/2);
            // sum >= mid (sum이 찾고자 하는 값)
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