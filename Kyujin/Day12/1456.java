import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        final int LIMIT = 10000000;
        boolean[] arr = new boolean[LIMIT + 1];

        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        int cnt = 0;
        for (int i = 2; i <= LIMIT; i++) {
            if ((long) i * i > m) break;
            if (arr[i] == false) continue;

            long sqrt = (long) i;
            long mul = (long) i + i;

            /*
             * 다음 제곱을 구하는 과정에서 오버플로우가 발생할 수 있기 때문에
             * sqrt * i <= m 이 조건 확인을
             * sqrt <= m / i 로 확인해줘야 함
             * */
            while (sqrt <= m / i) { // 제곱수가 m보다 작으면
                sqrt *= i; // 제곱하고
                if (sqrt >= n) cnt++; // n보다 크면 정답개수 늘려줌
            }

            // 배수 제거 로직
            long check = Math.min((long) LIMIT, m);
            // m이 예를 들어 10000이라면 굳이 10000001까지 배수 제거할 필요 없음
            while (mul <= check) {
                arr[(int) mul] = false;
                mul += i;
            }
        }

        bw.write(sb.append(cnt).toString());
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}