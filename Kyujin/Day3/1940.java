import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        // 풀이 작성 시작 =====================

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(list);

        int start = 0, end = n - 1, count = 0;
        int sum = list[start] + list[end];
        while (start <= end) {
            if (start == end) sum = list[start];
            else sum = list[start] + list[end];

            if (sum == m) {
                count++;
                start++;
                end--;
            }
            else if (sum > m) {
                end--;
            }
            else start++;
        }

        // 정답 출력 pw.println() =============
        pw.println(count);

        // 풀이 작성 끝 =======================

        br.close();
        pw.flush();
        pw.close();
    }
}
