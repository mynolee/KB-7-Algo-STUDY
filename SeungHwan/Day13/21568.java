import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1. A와 B의 최대공약수 gcd를 구한다
         * 2. C가 gcd로 나누어 떨어지지 않으면 -1 리턴
         * 3. 나누어 떨어지면 확장 유클리드 호재법 실행해, Ax + By = gcd를 만족하는 기본 해를 찾음
         * 4. 기본 해에 C / G 를 곱해서 정답을 찾는다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        // 1. A와 B의 최대공약수 gcd를 구한다
        long gcd = gcd(A, B);

        // 2. C가 gcd로 나누어 떨어지지 않으면 -1 리턴
        if (C % gcd != 0) {
            System.out.println(-1);
            return;
        }

        /**
         * 확장 유클리드 호재법
         * Ax + By = gcd(A,B)
         */
        // 3. Ax + By = gcd(A, B)를 만족하는 기본 해 구하기
        long[] result = extendedGcd(A, B);
        long x0 = result[0];
        long y0 = result[1];

        // 4. Ax + By = C 형태에 맞춰 해를 확대하기
        long x = x0 * (C / gcd);
        long y = y0 * (C / gcd);

        System.out.println(x + " " + y);

    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long[] extendedGcd(long a, long b) {
        if (b == 0) {
            return new long[]{1, 0}; // 기저 조건: Ax + 0y = A -> x=1, y=0
        }

        // 재귀적으로 다음 단계의 x', y'를 구해옴
        long[] next = extendedGcd(b, a % b);
        long xNext = next[0];
        long yNext = next[1];

        // 현재 단계의 x, y 계산 규칙 적용
        long x = yNext;
        long y = xNext - (a / b) * yNext;

        return new long[]{x, y};
    }
}
