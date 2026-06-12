import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // [0]: 회의 시작 시간, [1]: 회의 끝 시간
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int answer = 0;
        int cur = 0;
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            if (start >= cur) {
                cur = end;
                answer++;
            }
        }
        System.out.println(answer);

        // 끝 시간 빠른 순서로 정렬, 같으면 시작 시간 빠른 순서로 정렬
        /*
        끝 시간이 같을 때 시작 시간이 늦은 것이 더 좋지 않냐고 생각할 수 있지만
        끝 시간이 같으면 어차피 다음 회의 가능성은 같음
        실제로 (0, 1), (1, 1)이 있을 때
        시작 시간 빠른 순: (0, 1) -> (1, 1) 2개 모두 가능
        시작 시간 느린 순: (1, 1) 1개만 가능
        따라서 시작 시간도 빠른 순으로 정렬하는 것이 좋음
         */
    }
}
