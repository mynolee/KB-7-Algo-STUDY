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

        int[] cards = new int[n];
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        for (int card : cards) q1.offer(card);

        int result = 0;

        while (q1.size() + q2.size() >= 2) {
            int min1 = getMin(q1, q2);
            int min2 = getMin(q1, q2);
            int sum = min1 + min2;
            result += sum;
            q2.offer(sum);
        }

        bw.write(sb.append(result).toString());

        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static int getMin(Deque<Integer> q1, Deque<Integer> q2) {
        if (q1.isEmpty()) return q2.poll();
        if (q2.isEmpty()) return q1.poll();

        return q1.peek() <= q2.peek() ? q1.poll() : q2.poll();
    }
}
