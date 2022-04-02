package 이분탐색.두용액;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R]에서 X 이상의 수 중 제일 왼쪽 인덱스를 리턴하는 함수
        // 그런 게 없다면 R + 1을 리턴한다.
        int result = R+1;

        while(L<=R) {
            int mid = (L+R)/2;
            if(A[mid] >= X) {
                result = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return result;
    }

    static void pro() {
        // A에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(A, 1, N+1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for(int left = 1; left <= N-1; left++) {
            // A[left] 용액을 쓸 것이다. 고로 -A[left]와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
            int candidate = lower_bound(A, left+1, N, -A[left]);

            // A[result - 1]와 A[result] 중에 A[left]와 섞였을 때의 정보를 정답에 갱신시킨다.
            if(left + 1 <= candidate - 1 && Math.abs(A[candidate-1]+A[left]) < best_sum) {
                best_sum = Math.abs(A[candidate-1]+A[left]);
                v1 = A[left];
                v2 = A[candidate-1];
            }

            if(candidate <= N && Math.abs(A[candidate]+A[left]) < best_sum) {
                best_sum = Math.abs(A[candidate]+A[left]);
                v1 = A[left];
                v2 = A[candidate];
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);

    }

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
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

