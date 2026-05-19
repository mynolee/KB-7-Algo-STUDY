import java.util.*;

class Solution {
    private int answer = 0;

    public int solution(int n) {
        // board[row] = col (row번 행에 놓은 퀸의 열 위치 저장)
        int[] board = new int[n];
        dfs(board, n, 0);
        return answer;
    }

    private void dfs(int[] board, int n, int row) {
        // 모든 행에 퀸을 하나씩 배치한 경우
        if (row == n) {
            answer++;
            return;
        }
        // 현재 row 행에서 가능한 col 위치 하나씩 시도
        for (int col = 0; col < n; col++) {
            board[row] = col;
            // 현재 위치에 퀸을 놓을 수 있으면 다음 행으로 이동
            if (isValid(board, row)) {
                dfs(board, n, row + 1);
            }
        }
    }

    private boolean isValid(int[] board, int row) {
        // 이전 행들에 놓인 퀸들과 충돌하는지 확인
        for (int prev = 0; prev < row; prev++) {
            // 같은 열이면 공격 가능 - false
            if (board[prev] == board[row]) {
                return false;
            }
            // 행 차이와 열 차이가 같으면 같은 대각선
            if (Math.abs(row - prev) == Math.abs(board[row] - board[prev])) {
                return false;
            }
        }
        return true;
    }
}
