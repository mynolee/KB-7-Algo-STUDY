import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static PrintWriter pw;
    public static int r;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int sum = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int start = max;
        int end = sum;

        while (start <= end) {
            int mid = (start + end) / 2;
            int temp = 0, cnt = 0;

            for (int i : arr) {
                temp += i;
                if (temp > mid) {
                    cnt++;
                    temp = i;
                }
            }

            if (cnt >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        pw.println(start);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
