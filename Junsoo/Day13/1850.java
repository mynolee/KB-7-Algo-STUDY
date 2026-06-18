import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 범위 때문에 전부 long 타입 써야 함
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 1의 개수가 주어지는 것이므로 1의 개수끼리 최대공약수를 구하면 됨
        // 그 개수만큼의 1을 출력하면 두 수의 최대공약수

        long oneCount = gcd(a, b);
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < oneCount; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
