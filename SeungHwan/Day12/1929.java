import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[N + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // 이미 소수가 아닌걸로 판명났으면 continue
            if (isNotPrime[i]) continue;

            // i의 배수들을 소수에서 제외하는 방식 (이미 i * i 이전의 배수들은 이전 for문 단계에서 true 처리됨)
            for (int j = i * i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }       

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        } 

        System.out.print(sb);
    }
}
