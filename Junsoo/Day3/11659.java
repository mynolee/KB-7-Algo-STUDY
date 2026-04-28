import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 1번째 수부터 i번째까지의 합을 저장하면 연산 훨신 효율적
        int[] dpSum = new int[N + 1];
        // 1번째부터 생각
        for (int i = 1; i <= N; i++) {
            dpSum[i] = dpSum[i - 1] + scanner.nextInt();
        }

        for (int k = 0; k < M; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            // i부터 j까지 합이므로 (1번부터 j까지의 합) - (1번부터 i-1까지의 합)
            System.out.println(dpSum[j] - dpSum[i - 1]);
        }
    }
}