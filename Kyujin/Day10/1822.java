import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i : arr1) {
            if (Arrays.binarySearch(arr2, i) < 0) {
                sb.append(i + " ");
                cnt++;
            }
        }
        if (cnt == 0) pw.println(0);
        else {
            pw.println(cnt);
            pw.println(sb.toString());
        }

        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
