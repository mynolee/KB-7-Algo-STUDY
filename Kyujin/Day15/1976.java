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

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[] g = new int[n + 1];
        for (int i = 0; i <= n; i++) g[i] = i;

        // 입력할 때마다 유니온을 통해 그래프를 만들어준다.
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int conn = Integer.parseInt(st.nextToken());
                if (conn == 1) union(g, i, j);
            }
        }

        // 도시 여행은 모든 도시가 같은 조상이면 가능하다.
        st = new StringTokenizer(br.readLine());
        int[] cities = new int[m];
        for (int i = 0; i < m; i++) cities[i] = Integer.parseInt(st.nextToken());

        boolean can = true;
        for (int i = 0; i < m - 1; i++) {
            if (find(g, cities[i]) != find(g, cities[i + 1])) {
                can = false;
                break;
            }
        }

        if (can) bw.write("YES");
        else bw.write("NO");
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

