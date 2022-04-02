package 최소경로.최소비용구하기;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // Edge ( to: 어디로, weight: 얼마만큼의 비용 )
    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    // Info ( idx: 어떤 정점, dist: 어떤 정점까지의 비용 )
    static class Info {
        public int idx, dist;

        public Info() {}

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M, start, end;
    // 최소거리 저장 배열
    static int[] dist;
    // 인접 정점, weight 리스트
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        // 맨 처음 비용 저장 배열
        dist = new int[N + 1];
        // edge 정보 저장 리스트
        edges = new ArrayList[N + 1];
        for(int i = 1; i<=N; i++) edges[i] = new ArrayList<>();
        for(int i = 1; i<=M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화
        for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;

        // 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야함

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparing(o -> o.dist));
        // 다른 방법)
//        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);


        // 시작점에 대한 정보를 기록에 추가하고, 거리 배열에 갱신 ( 시작 위치는 거리가 0 )
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while(!pq.isEmpty()) {
            // 최소힙에 저장된 제일 작은 weight 꺼내기
            Info info = pq.poll();
            if(dist[info.idx] < info.dist) continue;
            for(Edge e : edges[info.idx]) {
                // e.to 정점으로 이동할 것이다!

                if(dist[info.idx] + e.weight >= dist[e.to]) continue; // 기존 to 까지의 거리와 이전 정점에서 to 정점으로 이동한 거리 비교

                // 더 짧으면 갱신해주기
                dist[e.to] = dist[info.idx] + e.weight;
                // 최소힙에 더 짧은 계산 결과 추가!
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
