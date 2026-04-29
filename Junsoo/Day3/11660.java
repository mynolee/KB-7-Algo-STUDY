import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // (i,1)부터 (i,j)까지의 행별 합을 저장하면 연산 훨신 효율적
        int[][] dpSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dpSum[i][j] = dpSum[i][j - 1] + scanner.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += (dpSum[j][y2] - dpSum[j][y1 - 1]);
            }
            System.out.println(sum);
        }
    }
}
