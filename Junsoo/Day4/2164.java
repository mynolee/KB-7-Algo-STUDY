import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            // 뒤에 넣기
            queue.offer(i);
        }

        // 마지막 한 수 남을 때까지
        while (queue.size() > 1) {
            // 맨 앞 빼기
            queue.poll();
            // 다음 맨 앞을 빼서 맨 뒤에 넣기
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
