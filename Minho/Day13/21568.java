import java.io.*;
import java.util.*;

public class Main {

    static class Result {
        long x;
        long y;

        Result(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long gcd = gcd(A, B);

        if (C % gcd != 0) {
            System.out.println(-1);
            return;
        }

        Result r = extendedGcd(A, B);

        long k = C / gcd;

        System.out.println(r.x * k + " " + r.y * k);
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static Result extendedGcd(long a, long b) {

        if (b == 0) {
            return new Result(1, 0);
        }

        Result prev = extendedGcd(b, a % b);

        long x = prev.y;
        long y = prev.x - (a / b) * prev.y;

        return new Result(x, y);
    }
}