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

        Arrays.sort(twoSum);
        
        // twoSum 을 target으로 잡으면 안됨!! 왜냐면 twoSum 자체가 n^2 크기라 for 문 자체는 하나여도 순회하는게 N^2 이라 시간 초과남
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int target = U[i] - U[j];

                if (Arrays.binarySearch(twoSum, target) >= 0) { // 존재한다면
                    System.out.println(U[i]);
                    return;
                }
            }
        }
    }
}
