import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return Integer.compare(a, b);
            }
            return Integer.compare(Math.abs(a), Math.abs(b));
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
