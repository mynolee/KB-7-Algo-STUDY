import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int limit = (int) Math.sqrt(B);

        boolean[] isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= limit; i++) {

            if (!isPrime[i]) continue;

            long value = (long) i * i;

            while (value <= B) {

                if (value >= A) {
                    count++;
                }

                if (value > B / i) {
                    break;
                }

                value *= i;
            }
        }

        System.out.println(count);
    }
}