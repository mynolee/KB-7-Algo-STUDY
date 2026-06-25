import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 자신을 Union-Find 배열의 부모로 설정
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCount = Integer.parseInt(st.nextToken());

        // 아는 사람이 아무도 없을 때
        if (knowCount == 0) {
            // 그냥 모든 파티의 수 출력
            System.out.println(M);
            return;
        }

        // 아는 사람이 1명 이상일 때
        int[] whoKnows = new int[knowCount];
        for (int i = 0; i < knowCount; i++) {
            whoKnows[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 정보를 미리 저장해둘 리스트
        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        // 2. 파티를 입력받으면서 같은 파티에 참여한 사람들을 하나의 집합으로 합침
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pCount = Integer.parseInt(st.nextToken());

            int firstPerson = Integer.parseInt(st.nextToken());
            parties[i].add(firstPerson);

            for (int j = 1; j < pCount; j++) {
                int nextPerson = Integer.parseInt(st.nextToken());
                parties[i].add(nextPerson);

                // 같은 파티의 사람들을 첫번째 사람의 집합으로 합집합
                union(firstPerson, nextPerson);
            }
        }

        // 3. 파티를 돌면서 거짓말 할 수 있는지 판별
        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;

            for (int person : parties[i]) {
                // 해당 파티원의 대표 부모 찾기
                int personParent = find(person);

                // 진실을 아는 사람 중 한명이라도 같은 그룹에 있으면 거짓말 불가
                for (int truthPerson : whoKnows) {
                    if (personParent == find(truthPerson)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            if (canLie) answer++;
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}

