package 정렬.단어정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
    int length;
    String word;

    public Info(int _length, String _word) {
        this.length = _length;
        this.word = _word;
    }

    @Override
    public int compareTo(Info o) {
        if(this.length == o.length) return word.compareTo(o.word);
        else return this.length - o.length;
    }
}

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static Info[] infos;
    static int N;

    static void input() {
        N = scan.nextInt();
        infos = new Info[N];
        for(int i = 0; i < N; i++) {
            String word = scan.nextLine();
            infos[i] = new Info(word.length(), word);
        }
    }

    static void pro() {
        Arrays.sort(infos, 0, N);
        for(int i = 0; i < N; i++) {
            if( i == 0 || (infos[i].word).compareTo(infos[i-1].word) != 0) {
                sb.append(infos[i].word).append('\n');
            }
        }
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