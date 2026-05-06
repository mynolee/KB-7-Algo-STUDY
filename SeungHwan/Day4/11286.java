import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(num);
            } else {    // 0일때
                if (pq.isEmpty()) { // 비어있는 경우
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
