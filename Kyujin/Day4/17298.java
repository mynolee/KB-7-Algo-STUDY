import java.io.*;
import java.nio.Buffer;
import java.text.FieldPosition;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && l[s.peek()] < l[i]) {
                int top = s.pop();
                answer[top] = l[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            answer[s.pop()] = -1;
        }

        for (int i : answer) {
            pw.print(i + " ");
        }
        // **** 정답 출력 pw.println(answer) ========

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
