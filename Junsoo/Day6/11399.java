import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);
        // 총 소요 시간
        int answer = 0;
        // 현재 사람에게 필요한 총 시간
        int cur = 0;
        for (int i = 0; i < n; i++) {
            // 이전 사람까지 소요 시간 + 현재 사람 소요 시간
            cur += times[i];
            answer += cur;
        }
        System.out.println(answer);
    }
}
