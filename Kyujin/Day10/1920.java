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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] find = new int[m];
        int[] copiedFind = new int[m];
        HashMap<Integer, Integer> hashTable = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            find[i] = num;
            hashTable.put(num, 0);
        }

        System.arraycopy(find, 0, copiedFind, 0, find.length);

        Arrays.sort(arr);
        Arrays.sort(copiedFind);

        int idx = 0;
        for (int i = 0; i < m; i++) {
            while (idx < n - 1 && arr[idx] < copiedFind[i]) {
                idx++;
            }

            if (arr[idx] == copiedFind[i]) hashTable.put(copiedFind[i], 1);
        }

        for (int i : find) {
            pw.println(hashTable.get(i));
        }

        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
