import java.util.Scanner;

//public class Solution {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        int tt = scan.nextInt();
//        for(int t = 1; t <= tt; t++) {
//            sb.append("#" + t +" " );
//        }
//        System.out.println(sb);
//    }
//}
import java.util.Scanner;

import java.util.*;
class Solution {
    class Edge implements Comparable<Edge> {
        int stage;
        double rate;

        public Edge(int _stage, double _rate) {
            this.stage = _stage;
            this.rate = _rate;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.rate, o.rate);
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Edge[] edges = new Edge[N];
        int n = stages.length, a = stages.length;

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(stages[j] == i+1) cnt++;
            }
            edges[i] = new Edge(i+1, (double)cnt/a);
            a -= cnt;
        }
        Arrays.sort(edges, 0, N);
        for(int i = 0; i < N; i++) {
            answer[i] = edges[i].stage;
        }

        return answer;
    }
}
