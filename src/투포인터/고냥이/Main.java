package 투포인터.고냥이;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
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
    static FastReader scan = new FastReader();
    static String A;
    static int N, kind;
    static int[] cnt;

    static void input() {
        N = scan.nextInt();
        A = scan.nextLine();
        cnt = new int[26];
    }

    static void pro() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            while(kind > N) {
                erase(A.charAt(L++));
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    static void add(char x) { // x라는 알파벳 추가
        cnt[x - 'a']++;
        if (cnt[x - 'a'] == 1) {// 원래 0이였다. 새롭게 등장한 문자
            kind++;
        }
    }
    static void erase(char x) { // x라는 알파벳 제거
        cnt[x-'a']--;
        if (cnt[x-'a']==0) {
            kind--;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
