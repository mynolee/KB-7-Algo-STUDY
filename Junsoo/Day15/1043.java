import java.util.*;
import java.io.*;

public class Main {
    private static int[] parent;
    private static int[] truthPeople;
    private static List<Integer>[] parties;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        parties = new ArrayList[m];

        st = new StringTokenizer(br.readLine());
        int truthCount =  Integer.parseInt(st.nextToken());

        // 진실을 아는 사람이 없으면 모든 파티 거짓말 가능 -> 파티 수 출력
        if (truthCount == 0) {
            System.out.println(m);
            return;
        }

        truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            // 같은 파티 사람들 묶기 위한 대표 사람(노드)
            int head = Integer.parseInt(st.nextToken());
            parties[i].add(head);

            for (int j = 1; j < size; j++) {
                int person =  Integer.parseInt(st.nextToken());
                parties[i].add(person);
                union(head, person);
            }
        }

        int answer = 0;
        // 각 파티에서 거짓말 할 수 있는지 확인
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                for (int truth : truthPeople) {
                    // 파티에 한 명이라도 진실을 아는지 확인 -> 있으면 거짓말 불가
                    if (find(person) == find(truth)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) {
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }
        System.out.println(answer);
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
