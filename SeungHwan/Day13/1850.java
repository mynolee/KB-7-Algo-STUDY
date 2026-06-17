import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        /**
         * 재미있는 사실
         * 1로만 이루어진 두 수의 GCD는
         * 두 수의 1의 갯수의 최대공약수만큼 1을 출력해주면 그게 정답
         */

        long a = A;
        long b = B;
        while (b % a != 0) {
            long r = b % a;
            b = a;
            a = r;
        }

        long gcd = a;

        for (long i = 0; i < a; i++) {
            System.out.print("1");
        }
    }
}
