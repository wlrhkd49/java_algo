package 그래프.물통;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class State1 {
    int[] X;
    State1(int[] _X) {
        X = new int[3];
        for(int i=0; i<3; i++) X[i] = _X[i];
    }

    State move(int from, int to, int[] Limit) {
        // from 물통에서 to 물통으로 물을 옮긴다.
        int [] nX = new int[]{X[0], X[1], X[2]};

        // to가 먼저 넘침
        if(X[from] + X[to] >= Limit[to]) {
            nX[from] -= Limit[to] - X[to];
            nX[to] = Limit[to];
        }
        else {
            nX[to] += X[from];
            nX[from] = 0;
        }

        return new State(nX);
    }
}

public class sol {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() {
        Limit = new int[3];
        for(int i = 0; i<3; i++) Limit[i] = scan.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;

        Q.add(new State(new int[] {x1, x2, x3}));

        while(!Q.isEmpty()) {
            State st = Q.poll();

            if(st.X[0] == 0) possible[st.X[2]] = true;
            for(int from=0; from<3; from++) {
                for(int to=0; to<3; to++) {
                    if(from == to) continue;
                    State nxt = st.move(from, to, Limit);

                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
        // BFS 과정 시작
    }

    static void pro() {
        bfs(0, 0, Limit[2]);

        for(int i=0; i<=Limit[2]; i++) {
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
