import java.util.*;
import java.io.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 대표 노드를 자기 자신으로 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int isConnected =  Integer.parseInt(st.nextToken());

                // i번 도시와 j번 도시가 연결되어 있으면 같은 집합으로 union
                if (isConnected == 1) {
                    union(i, j);
                }
            }
        }

        // 첫번째 도시의 대표 노드 번호와 이후의 도시들도 다 같은 대표 노드를 가지는지 확인
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start =  Integer.parseInt(st.nextToken());
        int root = find(start);
        for (int i = 0; i < m - 1; i++) {
            int city =  Integer.parseInt(st.nextToken());

            if (find(city) != root) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
