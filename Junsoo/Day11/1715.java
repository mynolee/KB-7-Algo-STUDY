import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
//        최소 비용 만들려면 가장 작은 두 묶음을 합쳐야 함
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            answer += sum;
            pq.offer(sum);
        }
        System.out.println(answer);
    }
}
