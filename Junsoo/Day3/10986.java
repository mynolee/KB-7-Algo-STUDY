import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        long answer = 0;
        // 누적 합 저장
        long sum = 0;
        // 이전에 같은 나머지가 나온 횟수 = 나누어 떨어지는 구간 수
        // 이전까지의 누적합 중 나머지가 같은 누적합 개수 저장
        long[] count = new long[M];
        // 누적합의 나머지가 0이면 자기 자신만으로도 나누어 떨어지는 것이므로 count[0]은 1인 상태로 시작
        // 이렇게 해야 0일 때마다 자기 자신이 포함된 +1이 됨
        count[0] = 1;
        for (int i = 0; i < N; i++) {
            sum += scanner.nextInt();
            int remainder = (int) (sum % M);
            // 이전까지의 구간 개수를 더하고 자기 자신도 포함시켜서 이후 해당 구간에 포함되도록 함
            answer += count[remainder];
            count[remainder]++;
        }

        System.out.println(answer);
    }
}
