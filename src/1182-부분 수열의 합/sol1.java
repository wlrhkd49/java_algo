import java.util.Scanner;

public class sol1 {
    static Scanner scan = new Scanner(System.in);
    static int N, S, ans;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for(int i=1; i<=N; i++) nums[i] = scan.nextInt();
    }

    //k번째 원소를 포함시킬 지 정하는 함수
    //value:= k-1 번째 원소까지 골라진 원소들의 합

    static void rec_func(int k, int value) {
        if(k==N+1) {
            //value가 S랑 같은지 확인하기
            if(value == S) ans++;
        }
        else {
            //k번째 원소를 포함시킬 지 결정하고 재귀호출 해주기
            // Include (k번째 원소를 포함했으므로 추가한 값을 호출)
            rec_func(k+1, value + nums[k]);
            // Not Include
            rec_func(k+1, value);
        }
    }
    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, 0);
        // ans가 정말 "진 부분집합"만 다루는 지 확인하기
        if(S==0){
            ans--; // 공집합에 대한 정답을 추가한것을 빼준다.
        }
        System.out.println(ans);
    }
}