import java.io.*;
import java.util.StringTokenizer;

public class solution2 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        // M 번지까지 필요
        selected = new int[M + 1];
    }

    static int N, M;
    // 지금까지 어떤 결과가 나왔는지 확인
    static int[] selected;
    // Recurrence Function (재귀함수)
    // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M 개를 고르지 않음 => k번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다
    static void rec_func(int k) {
        if (k == M + 1) { // 다 골랐다!
            // selected[1...M] 배열이 새롭게 탑색된 결과
            // for 문을 돌면서 검색될 결과를 출력
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k-1]; // 이전의 수를 정함
            if(start == 0) start = 1;
            // 1~N 까지를 k 번 원소로 한 번씩 정하고,
            // 후보지는 이전의 수보다 크다
            for(int cand = start; cand <= N; cand++) {
                selected[k] = cand;
                // 매번 k+1 번부터 M을 모두 탐색하는 일을 해야 하는 상황
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(sb.toString());

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
