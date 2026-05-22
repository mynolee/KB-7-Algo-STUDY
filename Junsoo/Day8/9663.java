import java.util.*;
import java.io.*;

public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // board[row] = col (row번 행에 놓은 퀸의 열 위치 저장)
        int[] board = new int[N];
        dfs(board, N, 0);
        System.out.println(answer);
    }

    private static void dfs(int[] board, int N, int row) {
        if (row == N) {
            // 모든 행에 퀸을 하나씩 배치한 경우
            answer++;
            return;
        }
        for (int col = 0; col < N; col++) {
            board[row] = col;
            // 현재 위치에 퀸을 놓을 수 있으면 다음 행으로 이동
            if (isValid(board, row)) {
                dfs(board, N, row + 1);
            }
        }
    }

    private static boolean isValid(int[] board, int row) {
        // 이전 행들에 놓인 퀸들과 충돌하는지 확인
        for (int prev = 0; prev < row; prev++) {
            if (board[prev] == board[row]) {
                // 같은 열이면 공격 가능 - false
                return false;
            }
            if (Math.abs(row - prev) == Math.abs(board[row] - board[prev])) {
                // 행 차이와 열 차이가 같으면 같은 대각선
                return false;
            }
        }
        return true;
    }
}
