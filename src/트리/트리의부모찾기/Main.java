package 트리.트리의부모찾기;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

//11725
public class Main {

    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input() {
        // 인접 리스트 구성하기
        n = scan.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            // 정점 x 와 인접 노드 y 입력
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // dfs(x, par) != 정점 x 의 부모가 par 였고, x의 children들을 찾아주는 함수
    static void dfs(int x, int par) {
        // 인접한 노드들 탐색
        for(int y: adj[x]) {
            // 내 부모이므로 무시
            if( y == par ) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void pro() {
        // 1 번 정점이 ROOT 이므로 여기서 시작해서 Tree의 구조를 파악하자
        // root 없으므로 -1
        dfs(1, -1);

        // 정답 출력
        for(int i=2; i<=n; i++)
            sb.append(parent[i]).append('\n');
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
