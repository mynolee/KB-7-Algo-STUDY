import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            original[i] = Integer.parseInt(st.nextToken());
        }

        int[] originalSorted = new int[n];
        System.arraycopy(original, 0, originalSorted, 0, n);
        Arrays.sort(originalSorted);

        int maxDist = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && originalSorted[i] == originalSorted[i + 1]) continue;

            if (i != 0 && originalSorted[i] == originalSorted[i - 1]) {
                for (int j = n - 1; j >= 0; j--) {
                    if (originalSorted[i] == original[j]) {
                        maxDist = Math.max(maxDist, j - i);
                        break;
                    }
                }
            } else {
                for (int j = idx; j < n; j++) {
                    if (originalSorted[i] == original[j]) {
                        maxDist = Math.max(maxDist, j - i);
                        idx = j + 1; // 찾은데 이후부터 탐색
                        break;
                    }
                }
            }
        }

        pw.println(maxDist + 1);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}