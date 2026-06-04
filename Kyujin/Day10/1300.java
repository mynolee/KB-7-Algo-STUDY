import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());

        long start = 0L;
        long end = n * n;
        long result = 0L;
        while (start <= end) {
            long mid = (long) Math.floor((start + end) / 2);
            if (smallNumbers(mid, n) >= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        while (true) {
            boolean find = false;
            for (int i = 1; i <= n; i++) {
                if (start % i == 0 && start / i <= n) {
                    pw.println(start);
                    find = true;
                    break;
                }
            }
            if (find) break;
            start++;
        }

        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static long smallNumbers(long target, long n) {
        long cnt = 0L;

        for (int i = 1; i <= n; i++) {
            long temp = target / i;
            if (temp >= n) cnt += n;
            else cnt += temp;
        }

        return cnt;
    }
}