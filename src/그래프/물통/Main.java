package 그래프.물통;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
class State {
    int[] X;

    // x1, x2, x3 정보를 가지고 새로운 State 생성
    State(int[] _X) {
        X = new int[3];
        for(int i=0; i<3; i++) X[i] = _X[i];
    }


    State move(int from, int to, int[] Limit) {
        // from 몸통에서 to 물통으로 물을 옮긴다.
        int[] nX = new int[]{X[0], X[1], X[2]};

        // 1. to가 다 차는지
        if(X[from] + X[to] >= Limit[to]) {
            nX[from] -= Limit[to] - X[to];
            nX[to] = Limit[to];
        }
        // 2. from이 먼저 비는지
        else {
            nX[to] += X[from];
            nX[from] = 0;
        }

       return new State(nX);
    }
}

//2251
public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    // A, B, C 물통의 최대 용량을 나타내는 배열
    static int[] Limit;
    // A가 0일 때 남은 C의 값에 따라 가능한 상태인지 확인하는 배열
    static boolean[] possible;
    // 처리한 State 인지 확인하는 배열
    static boolean[][][] visit;

    static void input() {
        Limit = new int[3];
        // A, B, C 최대 용량 입력
        for(int i = 0; i<3; i++) Limit[i] = scan.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    // bfs
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        // 처음 State 방문 처리
        visit[x1][x2][x3] = true;
        // BFS 시작
        Q.add(new State(new int[] {x1, x2, x3}));

        while(!Q.isEmpty()) {
            State st = Q.poll();
            // a가 비어있다면
            if(st.X[0] == 0) possible[st.X[2]] = true; // possible(Limit) = true;
            // 완전 탐색 시작
            for(int from=0; from<3; from++) {
                for(int to=0; to<3; to++) {
                    // 같은 물통엔 ㄴㄴ
                    if(from == to) continue;
                    // 움직인 이후 State를 nxt에 저장
                    State nxt = st.move(from, to, Limit);

                    // 방문하지 않은 State 라면
                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
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
