import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    static void dfs(int row, int col, int count) {
        if (count >= answer) {
            return;
        }

        if (row == 10) {
            answer = Math.min(answer, count);
            return;
        }

        if (col == 10) {
            dfs(row + 1, 0, count);
            return;
        }

        if (board[row][col] == 0) {
            dfs(row, col + 1, count);
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (paper[size] > 0 && canAttach(row, col, size)) {
                attach(row, col, size, 0);
                paper[size]--;

                dfs(row, col + 1, count + 1);

                attach(row, col, size, 1);
                paper[size]++;
            }
        }
    }

    static boolean canAttach(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) {
            return false;
        }

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static void attach(int row, int col, int size, int value) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                board[i][j] = value;
            }
        }
    }
}

// xy로 모든 칸을 다 인덱스 하나로 좌표화.
// 1. xy는 좌표(x, y)가 아니라 0~99까지의 칸 번호(index)이다.
// 2. x = xy % 10, y = xy / 10 으로 현재 좌표를 구한다.
// 3. index 하나만 관리하면 backtracking(xy + 1, ...)으로 다음 칸 이동이 쉬워진다.
// visited 대신 attach 함수 사용
// Integer.MAX_VALUE 사용