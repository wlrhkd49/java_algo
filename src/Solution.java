import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tt = scan.nextInt();
        for(int t = 1; t <= tt; t++) {
            sb.append("#" + t +" " );
        }
        System.out.println(sb);
    }
}
