import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기에는 자기 자신만
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) { // 합집합
                 union(a, b);
            } else if (num == 1) {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }

    // 대표 노드 찾는 함수
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        // 대표 노드를 찾음과 동시에 자신의 부모를 대표 노드를 갈아끼우기
        return parent[x] = find(parent[x]);
    }

    // 두 집합 하나로 합치는 함수
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            // 대표 노드가 다르다면 한쪽 대표 노드 아래로 귀속시킴
            parent[rootB] = parent[rootA];
        }
    }
}
