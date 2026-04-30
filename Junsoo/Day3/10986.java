import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 누적 합 저장
        long[] ASum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            ASum[i] = ASum[i - 1] + scanner.nextInt();
        }

        // i: 끝 점, j: 시작 점인 모든 구간 계산
        long answer = 0;
        for (int j = 1; j <= N; j++) {
            for (int i = 0; i < j; i++) {
                if ((ASum[j] - ASum[i]) % M == 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
