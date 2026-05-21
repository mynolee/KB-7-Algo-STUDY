import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        arr = new int[m];   // M개의 숫자 담을 배열 생성(순서에 따라 다르므로 -> 순열)

        backtrack(n, m, visited, 0);
    }

    private static void backtrack(int n, int m, boolean[] visited, int currentLen) {
        if (currentLen == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                // 1
                visited[i] = true;
                arr[currentLen] = i;

                // 2
                backtrack(n, m, visited, currentLen + 1);

                // 3
                visited[i] = false;
            }
        }
    }
}