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

        int num;
        PriorityQueue<Integer> q = new PriorityQueue<>((m, old) -> {
            int res = Integer.compare(Math.abs(m), Math.abs(old));
            if (res == 0) {
                return m - old;
            }
            return res;
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                if (q.isEmpty()) pw.println(0);
                else pw.println(q.poll());
            } else {
                q.offer(num);
            }
        }

        /* 리뷰
        * 1. 우선순위큐에서 정렬기준을 직접 정할 수 있구나
        * 2. 람다식 결과에 따라 정렬을 함. 기본적으로 오름차순임.
        * a, b에 대해 '람다식 > 0'인 경우 a > b로 간주하고 b에 우선권을 부여함. (오름차순)
        * a, b에 대해 a > b인 경우 a가 우선권을 갖게 하고 싶다면,
        * a < b인 경우 람다식 > 0을 만들어주면 됨 (b-a)
        * */

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
