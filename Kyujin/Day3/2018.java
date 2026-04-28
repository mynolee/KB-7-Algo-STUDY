import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        // 제출용 (표준 입출력)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        // 풀이 작성 시작 =====================

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int sum = 1;
        int count = 1;
        for (int start = 1, end = 1; end < n;) {
            if (sum == n) {
                count++;
                sum -= start;
                start++;
            }
            else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        pw.println(count);

        // **** 정답 출력 pw.println();

        // 풀이 작성 끝 =======================

        br.close();
        pw.flush();
        pw.close();
    }
}
