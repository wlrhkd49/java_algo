package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        int idx, dist;

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M, start, end;
    static ArrayList<Edge>[] adj;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i <= M; i++) {
            int from = scan.nextInt(), to = scan.nextInt(), weight = scan.nextInt();
            adj[from].add(new Edge(to, weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start) {
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Info info = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보 이므로 버린다.
            if(dist[info.idx] < info.dist) continue;
            for(Edge e : adj[info.idx]) {
                if(dist[e.to] <= dist[info.idx] + e.weight ) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(start);
        System.out.println(dist[end]);
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
