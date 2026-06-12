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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[1000001];
        Arrays.fill(arr, true);

        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i <= m; i++) {
            int k = 2;
            while (i * k <= m) {
                arr[i * k] = false;
                k++;
            }
        }

        for (int i = n; i <= m; i++) {
            if (arr[i]) sb.append(i + "\n");
        }

        bw.write(sb.toString());
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}