import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());


            // A <= B 성립하도록
            if (A > B) {
                int tmp = A;
                A = B;
                B = tmp;
            }

            /**
             * 최대공약수 구하는 방법(유클리드 호제법)
             * -> 두 수 A와 B가 있을 때 (A > B) A를 B로 나눈 나머지를 구함
             * -> 그 다음 B를 나머지 R로 다시 나눔
             * -> 나머지가 0이 될 때 까지 무한 반복
             */

            int a = A;
            int b = B;

            while (b != 0) {
                int r = a % b;  // 나머지를 먼저 구함
                a = b;  // 나누어 지는 수 자리에 b를 다시 넣음
                b = r;  //나누는 수 자리에 나머지 r 넣음
            }

            // b가 0이 됐을때 a가 최대공약수(GCD)
            int GCD = a;

            /**
             * A * B = 최대공약수(GCD) * 최소공배수(LCM)
             * -> 최소공배수(LCM) = 
             * (A * B) / 최대공약수(GCD)
             */

            int LCM = (A * B) / GCD;
            sb.append(LCM).append("\n");
        }
        System.out.println(sb);
    }
}
