import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /*
        시행착오 1)
        진실을 아는 사람이 1
        파티에 진실을 아는 사람이 있으면 모두 진실을 아는 셈이 되게 처리
        파티가 12 23 이라면
        12에서 진실을 아는 사람이 1이므로 과장을 못하고, 이제 12가 진실을 알게 된다.
        23에서 진실을 아는 사람이 2이므로 과장을 못한다.

        문제 케이스: 23 -> 12
        23에서 진실을 아는 사람이 1이므로 과장을 할 수 있고,
        12에서 진실을 아는 사람이 1이므로 과장을 할 수 없다.
        그래서 1을 출력하게 됨. (정답은 0)

        시행착오 2)
        그래서 한번 파티를 싹 훑고 진실을 아는 사람을 싹 모은 다음 다시 파티를 훑기로 했다.
        23에서 진실을 아는 사람이 1이므로 패스
        12에서 진실을 아는 사람이 1이므로 진실을 아는 사람을 12로 업데이트

        다시 파티를 훑는단.
        23에서 진실을 아는 사람이 12이므로 과장을 할 수 없고,
        12에서 진실을 아는 사람이 123이므로 과장을 할 수 없다.
        정답 0이 잘 나온다.

        문제케이스: 34 => 23 => 12
        방금처럼 하면 파티를 두번만 훑기 때문에 34에서 과장을 할 수 있다는 틀린 답이 나온다.
        내 방법대로 하려면 파티를 m번 훑어야만 해결할 수 있다.

        시행착오 3)
        그럼 어떻게 해야 할까?
        파티원을 전부 union 한다.
         */

        int[] sets = new int[n + 1];
        for (int i = 0; i < sets.length; i++) sets[i] = i;

        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        for (int i = 0; i < len; i++) {
            int j = Integer.parseInt(st.nextToken());
            union(sets, 0, j);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> party = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            // 각 파티원 전부 유니온
            int first = party.get(0);
            for (int j = 1; j < len; j++) {
                union(sets, first, party.get(j));
            }
        }

        int result = 0;
        for (List<Integer> party : parties) {
            int knowPerson = find(sets, 0);
            boolean can = true;

            for (int person : party) {
                if (find(sets, person) == knowPerson) can = false;
            }

            if (can) result++;
        }

        bw.write(String.valueOf(result));
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static void union(int[] arr, int a, int b) {
        // a의 조상, b의 조상을 찾는다.
        int aTop = find(arr, a);
        int bTop = find(arr, b);
        // 조상이 다르다면, b의 조상을 a의 조상 밑으로 연결시켜준다.
        if (aTop != bTop) arr[bTop]= aTop;
    }

    public static int find(int[] arr, int target) {
        // 내 조상이 나와 같다면 멈춘다. (내가 그래프 맨 위라는 뜻)
        if (arr[target] == target) return target;
        else {
            // 아니라면 내 부모의 조상을 찾아 내 조상 값을 넣어준다.
            arr[target] = find(arr, arr[target]);
            return arr[target];
        }
    }
}

