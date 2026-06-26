import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());

        int[] truthPeople = new int[truthCount];

        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int partySize = Integer.parseInt(st.nextToken());
            int[] party = new int[partySize];

            for (int j = 0; j < partySize; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < partySize; j++) {
                union(party[0], party[j]);
            }

            parties.add(party);
        }

        int answer = 0;

        for (int[] party : parties) {
            boolean canLie = true;

            for (int person : party) {
                for (int truth : truthPeople) {
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

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}