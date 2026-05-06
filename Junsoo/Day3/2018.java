import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int left = 1, right = 1;
        // 범위 주의 long
        long sum = 1;
        int answer = 0;
        while (left <= N && right <= N) {
            if (sum == N) {
                answer++;
                sum -= left;
                left++;
            } else if (sum < N) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        System.out.println(answer);
    }
}
