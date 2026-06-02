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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] find = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            binarySearch(find[i], arr, 0, arr.length - 1);
        }
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static void binarySearch(int target, int[] arr, int start, int end) {
        if (start > end) {
            pw.println(0);
            return;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            pw.println(1);
            return;
        } else if (arr[mid] > target) {
            binarySearch(target, arr, start, mid - 1);
        } else {
            binarySearch(target, arr, mid + 1, end);
        }
    }
}
