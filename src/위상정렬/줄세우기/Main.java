package 위상정렬.줄세우기;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] indeg;
    // 인접 리스트 정의
    static ArrayList<Integer>[] adj;

    static void input() {
        // Adjacent List 생성 및 indegree 계산하기
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N+1];
        for(int i = 1 ; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        // 자료구조 ㅇ
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= N; i++) {
            if(indeg[i] == 0) queue.add(i);
        }

        // 정렬될 수 있는 정점이 있다면?
        while(!queue.isEmpty()) {
            // 1. 정렬 결과에 추가하기
            int x = queue.poll();
            sb.append(x).append(' ');

            // 2. 정점과 연결된 간선 제거하기
            for(int y : adj[x]) {
                indeg[y]--;
                // 3. 새롭게 "정렬될 수 있는" 정점
                if(indeg[y] == 0) queue.add(y);
            }
        }
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
