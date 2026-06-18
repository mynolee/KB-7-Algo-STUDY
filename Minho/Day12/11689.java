import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long result = n;
        long temp = n;

        for (long p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {

                // p는 n의 소인수
                result = result / p * (p - 1);

                // 같은 소인수 전부 제거
                while (temp % p == 0) {
                    temp /= p;
                }
            }
        }

        // 마지막에 남은 소인수가 있는 경우
        if (temp > 1) {
            result = result / temp * (temp - 1);
        }

        System.out.println(result);
    }
}