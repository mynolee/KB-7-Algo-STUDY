import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        int[][] originalIdx = new int[1000001][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            arr[i] = j;
            if (originalIdx[j][1] > 0) originalIdx[j][1]++;
            else {
                originalIdx[j][0] = i;
                originalIdx[j][1]++;
            }
        }

        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int idx = originalIdx[sorted[i]][0];
            while (sorted[i] != arr[idx]) idx++;
            max = Math.max(max, idx - i);
            originalIdx[sorted[i]][0] = idx + 1;
            // System.out.println(sorted[i] + " " + idx + " " + i);
        }

        pw.println(max + 1);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}

/*
더이상 정렬하지 않아도 될 때까지 버블정렬을 진행한다.
오름차순으로 정렬하는데,
각 싸이클마다 앞부터 시작해서 다음 숫자와 비교해서 앞 숫자가 더 크면 자리를 바꾼다.
12 23 34 45 ... 이런 식으로 말이다.
이렇게 하면 제일 큰 숫자는 맨 뒤로 갈 수밖에 없다.
12에서 바뀌고 23에서 바뀌고 34에서 바뀌고 계속 한칸씩 밀릴 테니까.
그럼 다음 싸이클은 n-1 n은 안봐도 된다.
12 23 ... n-2 n-1 까지만 갈 것이다.
i=1 부터해서 정렬이 다 될때까지 몇번의 사이클을 돌았는지를 구하는 것이다.

버블정렬의 시간복잡도는 n^2이다.
그러니까 버블정렬을 직접 하는 문제는 당연히 아니다.

*/