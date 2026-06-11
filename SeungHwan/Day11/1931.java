import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1. 회의가 빨리 끝나는 순으로 정렬하기
        // 2. 끝나는 시간이 같으면 시작시간 빠른걸 먼저 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 종료시간이 같다면
                    return o1[0] - o2[0];   // 음수나 0 리턴시 그대로, 양수일 시 swap
                }
                return o1[1] - o2[1];
            }
        });

        // 최대 회의 개수 찾기
        int count = 0;
        int prevEndTime = 0;    // 직전 회의 끝난 시

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= prevEndTime) {
                prevEndTime = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
