package 트리.트리순회;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] childs;

    static void input() {
        N = scan.nextInt();
        childs = new int[30][2];
        for(int i = 1; i <= N; i++) {
            char chr = scan.next().charAt(0);
            int chrIdx = (int)(chr - 'A');
            for(int k = 0; k < 2; k++) {
                char child = scan.next().charAt(0);
                if(child != '.') childs[chrIdx][k] = (int)(child - 'A');
                else childs[chrIdx][k] = -1;
            }
        }
    }

    static void preOrder(int x) {
        if(x == -1) return;
        sb.append((char)(x + 'A'));
        preOrder(childs[x][0]);
        preOrder(childs[x][1]);
    }

    static void inOrder(int x) {
        if(x == -1) return;
        inOrder(childs[x][0]);
        sb.append((char)(x + 'A'));
        inOrder(childs[x][1]);
    }

    static void postOrder(int x) {
        if(x == -1) return;
        postOrder(childs[x][0]);
        postOrder(childs[x][1]);
        sb.append((char)(x + 'A'));
    }

    static void pro() {
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        sb.append('\n');
        System.out.println(sb);
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