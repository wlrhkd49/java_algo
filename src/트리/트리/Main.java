package 트리.트리;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input() {
        n = scan.nextInt();
        child = new ArrayList[n]; // 해당 index ( 정점 ) 의 자식 정보
        leaf = new int[n]; // 해당 index ( 정점 ) 에서 단말 노드의 개수
        for(int i=0; i<n; i++) child[i] = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int par = scan.nextInt();
            if(par == -1) {
                root = i;
                continue;
            }
            else {
                child[par].add(i);
            }
        }
        // 지워져야하는 정점 번호
        erased = scan.nextInt();
    }

    static void dfs(int x) {
        // 자식 정보가 없으면 단말 노드이므로 1 지정
        if(child[x].isEmpty()) {
            leaf[x] = 1;
        }
        for(int y : child[x]) {
            dfs(y);
            // leaf[y] 가 계산됨
            // 서브트리 해결하고 가져와서 사용
            leaf[x] += leaf[y];
        }
    }

    static void pro() {
        // erased 찾아서 지워줌
        for(int i = 0; i<n; i++) {
            // i번째 정점의 자식 중에 삭제해야할 노드가 존재하면
            if(child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }
        // 루트 삭제되는 예외 생각
        if (root != erased) {
            dfs(root);
        }
        System.out.println(leaf[root]);
    }

    // 1068
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
