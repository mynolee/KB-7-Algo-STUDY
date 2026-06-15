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

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 인덱스에 숫자를 그대로 넣을 수 없으니 long 배열을 만들고 배열 값으로 숫자를 넣어준다.
        // 문제 조건에 max = min + 1000000이라고 했으니 max - min 크기로 배열을 만들어주면 된다.
        long[] arr = new long[(int) (max - min + 1)];
        for (int i = 0; i < max - min + 1; i++) {
            arr[i] = min + i;
        }

        // 2의 제곱부터 해서 min, max 사이에 배수가 있는지 확인해준다.
        // 제곱수의 모든 배수를 체크하면 시간초과가 나기 때문에 min~max 구간만 체크한다.
        // 배수일 경우 0으로 마킹해준다.
        for (long i = 2; i * i <= max; i++) {
            long sqrt = i * i;
            // 101을 4로 체크한다고 하면 100(4*25)부터 체크해주면 된다.
            // 나눠주면 버림이 자동으로 되고 다시 곱해주면 100을 만들 수 있다.
            long temp = (min / sqrt) * sqrt;
            if (temp < min) temp += sqrt;

            while (temp <= max) {
                int idx = (int) (temp - min);
                arr[idx] = 0;
                temp += sqrt;
            }
        }

        int cnt = 0;
        for (long l : arr) {
            if (l != 0L) cnt++;
        }

        bw.write(String.valueOf(cnt));
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    private static boolean isPel(int n) {
        String s = String.valueOf(n);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }
}