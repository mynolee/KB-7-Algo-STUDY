import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 제출용 (표준 입출력)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        // 풀이 작성 시작 =====================
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // range

        st = new StringTokenizer(br.readLine());
        int[] l = new int[n];
        for (int i = 0; i < n; i++) l[i] = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> d = new ArrayDeque<>();
        d.add(new int[]{0, l[0]});
        pw.printf(l[0] + " ");

        for (int i = 1; i < n; i++) {
            // 더 앞에 있는데 더 큰 수 제거
            while (true) {
                if (d.isEmpty()) {
                    d.add(new int[]{i, l[i]});
                    break;
                }

                if (d.peekLast()[1] >= l[i]) d.removeLast();
                else {
                    d.addLast(new int[]{i, l[i]});
                    break;
                }
            }

            // 인덱스 벗어난 수 제거
            while (true) {
                if (d.peekFirst()[0] <= i - r) d.removeFirst();
                else break;
            }

            pw.print(d.getFirst()[1] + " ");
        }

        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}