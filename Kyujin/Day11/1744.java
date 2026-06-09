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

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int idx = 0;
        int sum = 0;
        while (idx < n && arr[idx] < 0) {
            boolean calTwo = idx + 1 < n && arr[idx + 1] <= 0;
            int sum1 = calTwo ? arr[idx] * arr[idx + 1] : arr[idx];
            int sum2 = calTwo ? arr[idx] + arr[idx + 1] : arr[idx];
            sum += sum1 > sum2 ? sum1 : sum2;
            idx += calTwo ? 2 : 1;
        }

        idx = n - 1;
        while (idx >= 0 && arr[idx] > 0) {
            boolean calTwo = idx - 1 >= 0 && arr[idx - 1] > 0;
            int sum1 = calTwo ? arr[idx] * arr[idx - 1] : arr[idx];
            int sum2 = calTwo ? arr[idx] + arr[idx - 1] : arr[idx];
            sum += sum1 > sum2 ? sum1 : sum2;
            idx -= calTwo ? 2 : 1;
        }

        bw.write(sb.append(sum).toString());
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}