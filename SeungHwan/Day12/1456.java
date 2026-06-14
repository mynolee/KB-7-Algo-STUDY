import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 소수는 B의 제곱근까지만 구하면 됨
        // B의 최댓값인 10^14의 제곱근 : 10^7(천만)
        int Max = 10000000;
        boolean[] isNotPrime = new boolean[Max + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i <= Max; i++) {
            if (isNotPrime[i]) continue;

            for (int j = i * i; j <= Max; j += i) {
                isNotPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i <= Max; i++) {
            if (!isNotPrime[i]) {   // i가 소수라면
                long tmp = i;

                // 오버플로우 방지를 위해 temp * i <= B 대신 temp <= B / i 로 조건 검사
                while((double)tmp <= (double)B / i) {
                    tmp = tmp * i;
                    
                    if (tmp >= A) count++;
                }
            }
        }

        System.out.println(count);
    }
}
