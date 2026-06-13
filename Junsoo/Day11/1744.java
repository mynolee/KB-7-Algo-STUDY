import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        /*
        4가지 경우로 나누기
        1보다 큰 양수: 큰 수부터 2개씩 곱해서 더함
        1: 그냥 더함
        0: 음수가 하나 남았을 경우 0이 있으면 상쇄, 없으면 음수 그냥 더함
        음수: 작은 수부터 2개씩 곱해서 더함
         */
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int oneCount = 0; // 1이 총 몇 개인지 세서 그냥 더해야 함
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                negative.add(num);
            }
        }
        Collections.sort(positive, Collections.reverseOrder()); // 양수는 내림차순
        Collections.sort(negative); // 음수는 오름차순

        int answer = 0;
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                answer += positive.get(i) * positive.get(i + 1);
            } else {
                answer += positive.get(i);
            }
        }
        answer += oneCount;
        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                answer += negative.get(i) * negative.get(i + 1);
            } else  {
                if (zeroCount == 0) { // 0이 없을 경우 남은 음수 그대로 더함
                    answer += negative.get(i);
                } // 0이 있는 경우 0과 곱해서 자동 상쇄(더할 필요 없음)
            }
        }
        System.out.println(answer);
    }
}
