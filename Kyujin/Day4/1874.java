import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int input = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            while (input <= m) {
                stack.push(input);
                sb.append("+\n");
                input++;
            }

            if (!stack.isEmpty() && stack.peek() == m) {
                stack.pop();
                sb.append("-\n");
            } else {
                pw.println("NO");
                pw.close();
                return;
            }
        }

        pw.println(sb.toString());
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}