import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] ingredients = new int[N];
        for (int i = 0; i < N; i++) {
            ingredients[i] = scanner.nextInt();
        }
        // 정렬해서 중복 계산 없도록
        Arrays.sort(ingredients);

        // right는 뒤부터 계산
        int left = 0, right = N - 1;
        int sum = 0;
        int answer = 0;
        while (left < right) {
            sum = ingredients[left] + ingredients[right];
            // 한번 사용한 재료는 또 사용할 수 없으므로 한 바퀴만 돌아야 함
            // 가장 바깥의 두 수 조합부터 안까지 탐색
            if (sum == M) {
                answer++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer);
    }
}
