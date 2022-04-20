package 이분탐색.숫자카드2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static int lower_bound(int[] A, int L, int R, int x) {
        int ans = R + 1;
        // 왼쪽 끝 인덱스 찾음.
        while(L <= R) {
            int mid = (L+R)/2;
            if(A[mid] >= x) {
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static int upper_bound(int[] A, int L, int R, int x) {
        int ans = R + 1;
        while(L <= R) {
            int mid = (L+R)/2;
            if(A[mid] > x) {
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static void pro() {
        Arrays.sort(A, 1, N+1);
        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int low = lower_bound(A, 1, N, x);
            int up = upper_bound(A, 1, N, x);
            System.out.println(low);
            System.out.println(up);
            sb.append(up-low).append(' ');
        }
        sb.append('\n');
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