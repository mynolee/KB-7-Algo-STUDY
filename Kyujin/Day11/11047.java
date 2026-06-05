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
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curCnt = target / coins[i];
            target -= curCnt * coins[i];
            cnt += curCnt;
            if (target == 0) break;
        }

        pw.println(cnt);

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
