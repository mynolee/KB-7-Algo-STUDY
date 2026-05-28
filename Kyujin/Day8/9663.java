import java.io.*;
import java.util.*;

public class Main {
    public static int answer;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int[] board = new int[n];
        answer = 0;

        dfs(board, 0);

        pw.println(answer);
        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static void dfs(int[] board, int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) { // 현재 행의 c에 퀸을 배치하려 한다
            boolean can = true;

            for (int r = 0; r < row; r++) {
                // 이전 행까지의 퀸 배치를 확인
                // 만약 c에 배치된 퀸이 있다면 배치 못함
                if (board[r] == c) {
                    can = false;
                    break;
                }

                // 대각선에 퀸이 배치돼있다면 배치 못함
                if (Math.abs(row - r) == Math.abs(c - board[r])) {
                    can = false;
                    break;
                }
            }

            if (can) {
                board[row] = c;
                dfs(board, row + 1);
                board[row] = 0;
            }
        }
    }
}

/*
n-queen 문제
체스판 위에 퀸을 n개 배치해야하는데 퀸이 서로를 공격해서는 안 됨

보드판을 만들자
배열 하나로 해보자
 */