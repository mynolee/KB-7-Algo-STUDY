import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lessons = new int[N];
        int left = 0;   // 가장 긴 강의 길이(최소 성립 조건)
        int right = 0;  // 전부 합친 강의 길이(최대 성립 조건)

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            right += lessons[i];
            if (lessons[i] > left) {
                left = lessons[i];
            }
        }

        int answer = right;

        // 이분 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2;

            // M개 이하로 담을 수 있다면 더 작은 크기도 가능한지 탐색
            if (getRequiredBlurayCount(lessons, mid) <= M) {
                answer = mid;
                right = mid - 1;
            } else { // M개 안에 못 담는다면, 블루레이 크기를 키워야 함
                left =  mid + 1;
            }
        }

        System.out.println(answer);
    }
    
    private static int getRequiredBlurayCount(int[] lessons, int capacity) {
        int count = 1;  // 기본적으로 1장은 필요
        int sum = 0;

        for (int lesson : lessons) {
            if (sum + lesson > capacity) {
                // 현재 블루레이에 더 이상 못담으면 새 블루레이 추가
                count++;
                sum = lesson;   // 새 블루레이에 현재 강의 담기
            } else {
                sum += lesson;
            }
        }
        return count;
    }
}
