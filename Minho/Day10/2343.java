import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] lessons;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lessons = new int[N];

        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());

            left = Math.max(left, lessons[i]);
            right += lessons[i];
        }

        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canMake(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canMake(int size) {
        int count = 1;
        int sum = 0;

        for (int lesson : lessons) {
            if (sum + lesson > size) {
                count++;
                sum = lesson;
            } else {
                sum += lesson;
            }
        }

        return count <= M;
    }
}