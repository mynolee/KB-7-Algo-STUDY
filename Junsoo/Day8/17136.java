import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[10][10];
    // used[size] = size x size 색종이를 몇 개 사용했는지 저장
    static int[] used = new int[6];
    // 최솟값을 구해야 하므로 초기 값은 Integer.MAX_VALUE로
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int count) {
        // 이미 현재 사용 개수가 기존 최솟값보다 크면 더 이상 볼 필요 없음
        if (count >= answer) {
            return;
        }

        // 아직 덮지 않은 1 찾기
        int[] cur = findOne();
        // 1 없으면 모든 칸이 색종이로 덮인 것이므로 리턴
        if (cur == null) {
            answer = Math.min(answer, count);
            return;
        }

        int row = cur[0];
        int col = cur[1];
        // 큰 색종이부터 붙일 수 있는지 검사
        for (int size = 5; size >= 1; size--) {
            // 해당 크기 이미 5개 사용했다면 사용 불가
            if (used[size] == 5) {
                continue;
            }
            // 현재 위치에 size x size 색종이를 붙일 수 있는지 확인
            if (!canAttach(row, col, size)) {
                continue;
            }

            // 색종이 붙이기 -> 덮인 칸이므로 0으로 변경
            attach(row, col, size, 0);
            used[size]++;

            dfs(count + 1);

            // 백트래킹: 다시 떼기 -> 덮여야 할 칸이므로 1로 변경
            attach(row, col, size, 1);
            used[size]--;
        }
    }

    private static int[] findOne() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean canAttach(int row, int col, int size) {
        // 색종이가 종이 밖으로 나가면 안 됨
        if (row + size > 10 || col + size > 10) {
            return false;
        }
        // size x size 영역 안에 0이 하나라도 있으면 안 됨
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void attach(int row, int col, int size, int value) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                board[i][j] = value;
            }
        }
    }
}
