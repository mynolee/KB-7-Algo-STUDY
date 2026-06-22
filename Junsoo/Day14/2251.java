import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int water[] = new int[3];
        for (int i = 0; i < 3; i++) {
            water[i] =  Integer.parseInt(st.nextToken());
        }

        int[] from = new int[]{0, 0, 1, 1, 2, 2};
        int[] to = new int[]{1, 2, 0, 2, 0, 1};
        boolean[][] visited = new boolean[water[0] + 1][water[1] + 1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        List<Integer> answer =  new ArrayList<>();
        answer.add(water[2]);
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];

            for (int i = 0; i < from.length; i++) {
                int[] next = new int[]{a, b, water[2] - a - b};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                if (next[to[i]] > water[to[i]]) {
                    next[from[i]] = next[to[i]] - water[to[i]];
                    next[to[i]] = water[to[i]];
                }

                if (!visited[next[0]][next[1]]) {
                    q.offer(new int[]{next[0], next[1]});
                    visited[next[0]][next[1]] = true;
                    if (next[0] == 0) {
                        answer.add(next[2]);
                    }
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int c : answer) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
