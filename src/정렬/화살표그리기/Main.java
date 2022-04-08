package 정렬.화살표그리기;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 15970
public class Main {
    static Scanner scan = new Scanner(System.in);
    // 점 개수
    static int N;
    // 색깔별로 저장할 리스트
    static ArrayList<Integer>[] a;

    static void input() {
        // 점 개수 입력받기
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int color = 1; color<=N; color++) {
            // 색깔개수 만큼 리스트 생성
            a[color] = new ArrayList<>();
        }
        for(int i = 1; i<=N; i++) {
            // coord : 좌표, color : 색깔 정보
            // 특정 색깔에서 특정 위치 정보
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            // color인 색깔의 점이 coord에 놓여있음
            // a라는 컬러에대가 coord라는 점의 위치 추가
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        // 색깔이 color 인 점의 idx번째에 있는 점이 왼쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 왼쪽에 점이 없다면 무한대를 return
        if(idx == 0) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx-1);
    }

    static int toRight(int color, int idx) {
        // 색깔이 color 인 점의 idx번째에 있는 점이 오른쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 오른쪽에 점이 없다면 무한대를 return
        if(idx + 1 == a[color].size()) return Integer.MAX_VALUE;
        return a[color].get(idx+1) - a[color].get(idx);
    }

    static void pro() {
        // 색깔별로 정렬
        for (int color = 1; color<=N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        for (int color = 1; color<=N; color++) {
            // 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
            for (int i=0; i<a[color].size(); i++) {
                int left = toLeft(color, i); // 왼쪽 점까지의 거리
                int right = toRight(color, i); // 오른쪽 점 까지의 거리;
                ans += Math.min(left, right);
            }
        }

        // 정답 출력
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
