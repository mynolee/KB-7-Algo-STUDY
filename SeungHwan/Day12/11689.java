import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // n + 1 크기 배열이면 n이 최대 1조번이라 반복문 한번만 돌려도 바로 시간초과 남
//        boolean[] isGCD = new boolean[n + 1];

        // 처음에는 n개 모두 서로소 후보로 둠
        long count = n;

        // n 소인수 찾기 (제곱근까지만 반복해도 됨)
        for (long i = 2; i <= Math.sqrt(n); i++) {
            // i가 n의 약수라면 (뒤에 while에서 2, 3 등 소수부터 배제하고 가기 떄문에 자동으로 해당 소수의 배수들은 걸러짐)
            if (n % i == 0) {
                // 오일러 피 함수 적용 (i의 배수 갯수만큼 전체 n에서 제외)
                count = count - (count / i);
                
                // 이 while문 덕분에 시간이 확 줄어들음.
                while (n % i == 0) {    // 방금 처리한 소인수는 배제하기
                    n /= i;
                }
            }
        }
        
        // 만약 n 제곱근까지 소인수분해 다 했는데 n이 1보다 크다면
        // 그 남은 수 자체가 n 제곱근 보다 큰 소인수 라는 뜻
        /**
         * ex) n = 26일때 26의 제곱근은 약 5.09
         * 1. i = 2일때 while문에 의해 n = 13이 됨.
         * 2. 이후 i = 3, 4, 5일때 13은 안나누어 떨어져서 그대로 for문 종료
         * 3. for문 끝난 시점에도 n은 여전히 13
         */
        if (n > 1) {
            // 오일러 피 함수 적용
            count = count - (count / n);
        }

        System.out.println(count);
    }
}
