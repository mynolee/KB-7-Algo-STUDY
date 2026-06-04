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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int max = 0;
        int[] ab = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ab[idx] = arr[i] + arr[j];
                idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int target = arr[j] - arr[i];
                if (Arrays.binarySearch(ab, target) >= 0) {
                    max = Math.max(max, target + arr[i]);
                }
            }
        }

        pw.println(max);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
