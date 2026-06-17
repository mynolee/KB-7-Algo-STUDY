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
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        // 후보가 1 ~ n까지 가능한 상태.
        // 만약 n이 소수 k의 배수라면, 1 ~ n 사이에 있는 k의 배수들은 모두 탈락한다.
        // 따라서 k의 배수들을 제거하면 n - n/k개가 남는다.

        // 소인수를 모두 구한다.
        long temp = n;
        List<Long> list = new ArrayList<>();
        for (long i = 2; i * i <= n; i++) {
            if (temp % i == 0) {
                list.add(i);
                while (temp % i == 0) temp /= i;
            }
        }
        if (temp != 1) list.add(temp);

        // 소인수를 하나씩 보면서 배수 개수만큼 빼준다.
        // 예) 45의 소인수는 3, 5이므로 3의 배수 15(45/3)개를 빼주면 30개가 남고,
        // 남은 30개중에서 5의 배수 6(30/5)개를 뺴주면 24개가 남는다.
        long result = n;
        for (long p : list) {
            result = result - result / p;
        }

        bw.write(String.valueOf(result));
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}