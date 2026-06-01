import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static PrintWriter pw;
    public static int r;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int nod = Integer.parseInt(st.nextToken());
            int e;

            while ((e = Integer.parseInt(st.nextToken())) != -1) {
                int d = Integer.parseInt(st.nextToken());
                g.get(nod).add(new int[]{e, d});
            }
        }

        dfs(1, g, new boolean[n + 1], 0);

        pw.println(r);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static int dfs(int cur, List<List<int[]>> g, boolean[] v, int curDist) {
        v[cur] = true;

        int max1 = 0;
        int max2 = 0;
        for (int[] arr : g.get(cur)) {
            int nod = arr[0];
            int dist = arr[1];

            if (!v[nod]) {
                int remain = dist + dfs(nod, g, v, curDist + dist);

                if (remain > max1) {
                    max2 = max1;
                    max1 = remain;
                } else if (remain > max2) {
                    max2 = remain;
                }
            }

            r = Math.max(r, max1 + max2);
        }

        return max1;
    }
}
/*
 * 첫 노드에서 dfs를 하면 가장 긴 거리가 나올거라고 직관적으로 느껴지지만 그렇지 않다.
 * 왜냐하면 끝 노드에서 첫 노드로 가는 길보다 더 긴 길이 있을 수 있기 때문이다.
 * 뭔가 Top2를 저장해야 할 것 같은 느낌
 * 핵심 아이디어! 갈림길이 있을때마다 Top2를 뽑아서 트리를 만들어보고 지름을 갱신해주는것이다.
 * 예를 들어 두갈래길을 만났다고 하면, 지금까지 온 길이 지름에 포함됄 수도 있고
 * 지금까지 온 길을 제외한 두갈래길 각각이 이어져 지름이 될수도 있다.
 * 그러므로 계산을 해서 두 값을 더해주고 지름을 갱신해주는 것이다.
 * 현재까지의 지름보다 높으면 새로운 지름 루트를 찾은거다.
 */