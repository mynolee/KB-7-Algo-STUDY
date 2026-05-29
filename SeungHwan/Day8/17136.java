import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[10][10];
    static int[] paper = {5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int r, int c, int count) {
        // 현재 사용한 색종이 수가 이미 구한 값보다 크거나 같으면 종료
        if (count >= answer) return;

        // 행 탐색 다 했으면 다음 행으로
        if (c >= 10) {
            dfs(r + 1, 0, count);
            return;
        }

        // 보드 모든 칸을 다 탐색했으면 최솟값 갱신
        if (r >= 10) {
            answer = Math.min(answer, count);
            return;
        }

        if (board[r][c] == 1) {
            for (int size = 5; size >= 1; size--) {
                // 해당 사이즈의 색종이가 남아있고 붙일 수 있다면
                if (paper[size - 1] > 0 && isAttachable(r, c, size)) {
                    // 붙임 처리
                    attach(r, c, size, 0);
                    paper[size - 1]--;

                    // 다음 칸으로 탐색
                    dfs(r, c + 1, count + 1);

                    // 아니면 다시 떼기
                    attach(r, c, size, 1);
                    paper[size - 1]++;
                }
            }
        } else {
            // 0이면 다음칸
            dfs(r, c + 1, count);
        }
    }

    private static boolean isAttachable(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }


    private static void attach(int r, int c, int size, int state) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = state;
            }
        }
    }
}
