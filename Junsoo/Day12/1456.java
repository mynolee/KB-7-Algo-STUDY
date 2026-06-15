import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a =  Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 에라토스테네스의 체는 1부터 N까지의 수 중에서 소수를 한 번에 걸러내는 방법
        // 소수의 배수는 소수가 아님
        int limit = (int) Math.sqrt(b); // 루트 b까지의 소수만 탐색하면 됨
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true); // 처음에는 모두 소수라고 가정
        isPrime[0] = false;
        isPrime[1] = false; // 0, 1은 소수가 아님

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= limit; i++) {
            if (!isPrime[i]) {
                continue;
            }

            // n >= 2이므로 제곱부터 범위 판단
            long value = (long) i * i;
            while (value <= b) {
                if (value >= a) {
                    answer++;
                }
                // value *= i 전에 long 타입 오버플로우 방지 필요
                // value * i > b로 체크하면 오버플로우 날 수도 있으니까 이항해서 판단
                if (value > b / i) {
                    break;
                }
                value *= i;
            }
        }
        System.out.println(answer);
    }
}
