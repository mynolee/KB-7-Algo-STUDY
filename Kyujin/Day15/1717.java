import java.io.*;
import java.sql.Array;
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

        // n+1의 길이를 가진 배열을 만들어준다.
        int[] sets = new int[n + 1];
        for (int i = 0; i < sets.length; i++) sets[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 0이면 union을 수행한다.
            if (option == 0) union(sets, a, b);
            // 1이면 find를 수행한다. find를 수행할땐 재귀적으로 값을 업데이트해줘 시간복잡도를 줄인다.
            else {
                if (find(sets, a) == find(sets, b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }

        bw.write(sb.toString());
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

