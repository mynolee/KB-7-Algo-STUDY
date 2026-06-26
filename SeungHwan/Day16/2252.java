import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arrayLists.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayLists.get(a).add(b);
            // 진입차수 더 키큰 애 뒤로 미루기
            inDegree[b]++;
        }

        // 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            // 첫번째 진입 차수 = 0이 출발점 찾기
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (Integer next : arrayLists.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
