import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 양수 큐는 역순으로
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                plus.add(num);
            } else if (num < 0) {
                minus.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                zeroCount++;
            }
        }

        int sum = 0;
        while (plus.size() > 1) {
            int first = plus.remove();
            int second = plus.remove();
            sum += first * second;
        }
        if (!plus.isEmpty()) {
            // 1개 남았으면
            sum += plus.remove();
        }

        while (minus.size() > 1) {
            int first = minus.remove();
            int second = minus.remove();
            sum += first * second;
        }
        if (!minus.isEmpty()) {
            // 1개 남았는데 0 있으면 안더하고, 0 없으면 더해줌
            if (zeroCount == 0) {
                sum += minus.remove();
            }
        }

        // 1 있는거 처리
        sum += oneCount;
        System.out.println(sum);

    }
}
