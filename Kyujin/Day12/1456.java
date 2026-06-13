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

            long sqrt = (long) i * i;
            long mul = (long) i + i;

            while (sqrt <= m) {
                if (sqrt >= n) cnt++;
                sqrt *= i;
            }

            long check = Math.min((long) LIMIT, m);
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