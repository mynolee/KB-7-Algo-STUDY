import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        int count = 1;

        while (endIdx < N) {
            if (sum < N) {  // 아직 N보다 작을때
                endIdx++;
                sum += endIdx;
            } else if (sum == N) {  // N이랑 같을 때
                count++;
                endIdx++;
                sum += endIdx;
            } else { // N보다 커졌을 때
                sum -= startIdx;
                startIdx++;
            }
        }
        System.out.println(count);
    }
}
