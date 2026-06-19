import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long gcd = gcd(a, b);
        if (c % gcd != 0) bw.write(String.valueOf(-1));
        else {
            long[] xy = extendedGcd(a, b);
            long x = xy[0] * (c / gcd);
            long y = xy[1] * (c / gcd);
            bw.write(x + " " + y);
        }

        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static long gcd(long a, long b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static long[] extendedGcd(long a, long b) {
        if (b == 0) return new long[]{1, 0};
        else {
            long[] xy = extendedGcd(b, a % b);
            long x = xy[1]; // x = y`
            long y = xy[0] - xy[1] * (a / b); // y = x` - y` * q

            return new long[]{x, y};
        }
    }
}

