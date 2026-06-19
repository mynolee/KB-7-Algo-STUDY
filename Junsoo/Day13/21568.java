import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a =  Long.parseLong(st.nextToken());
        long b =  Long.parseLong(st.nextToken());
        long c =  Long.parseLong(st.nextToken());

        // c가 gcd(a, b)로 나누어 떨어지지 않으면 정수해 없음
        long gcd = gcd(a, b);
        if (c % gcd != 0) {
            System.out.println(-1);
            return;
        }

        // ax + by = gcd를 만족하는 x, y 구함
        long[] answer = extendedGcd(a, b);
        // ax + by = c를 만들기 위해 c / gcd 만큼 곱함
        long multiply = c / gcd;
        long x = answer[0] * (c / gcd);
        long y = answer[1] * (c / gcd);

        System.out.println(x + " " + y);
    }

    // ax + by = gcd(a, b)를 만족하는 x, y 구하는 함수
    private static long[] extendedGcd(long a, long b) {
        // b가 0이면 a * 1 + 0 * 0 = a, 따라서 x = 1, y = 0
        if (b == 0) {
            return new long[]{1, 0};
        }

        // b * x + (a % b) * y = gcd(a, b)의 해
        long[] next = extendedGcd(b, a % b);

        // 이전 단계의 해를 현재 단계의 해로 변환
        // b * prevX + (a % b) * prevY
        // = b * prevX + (a - (a / b) * b) * prevY
        // = a * prevY + b * (prevX - (a / b) * prevY)
        // 따라서 현재 x = prevY, 현재 y = prevX - (a / b) * prevY
        long[] result = new long[2];
        result[0] = next[1];
        result[1] = next[0] - (a / b) * next[1];
        return new long[]{result[0], result[1]};
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
