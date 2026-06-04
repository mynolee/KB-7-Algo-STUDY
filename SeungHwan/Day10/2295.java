import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];

        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        // 우선 2개씩 더하기
        int[] twoSum = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                twoSum[index] = U[i] + U[j];
                index++;
            }
        }

        // 앞서 14번째 줄에서 Arrays.sort(U)를 했기 때문에 twoSum도 자연스럽게 크기순으로 정렬돼있음.
        for (int i = N * N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int target = twoSum[i] + U[j];

                if (Arrays.binarySearch(U, target) >= 0) { // 존재한다면
                    System.out.println(target);
                    return;
                }
            }
        }
    }
}
