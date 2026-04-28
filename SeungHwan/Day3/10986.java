import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[N];
        // 합 배열 넣기
        sum[0] = A[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        // 나머지 배열로 변화
        long[] C = new long[M];
        for (int i = 0; i < N; i++) {
            int remainder = (int) (sum[i] % M);
            if (remainder == 0) answer++;
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            answer += C[i] * (C[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
