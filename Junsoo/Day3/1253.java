import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int left = 0, right = N - 1;

            while (left < right) {
                // 자기 자신 제외
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                long sum = arr[left] + arr[right];
                if (sum == target) {
                    answer++;
                    // 한 조합 찾으면 끝
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(answer);
    }
}
