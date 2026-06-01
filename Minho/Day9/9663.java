import java.io.*;

public class Main {
    static int N;
    static int count = 0;

    static int[] queen;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];
        dfs(0);

        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            queen[row] = col;

            if (isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == queen[row]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(queen[row] - queen[i])) {
                return false;
            }
        }

        return true;
    }
}

// 1차원 배열 생각
// math.abs 대신에 값 차이/값 차이가 1 혹은 -1인 경우로 생각해서 풀수도 ㅇㅇ. -- math.abs 안써도됌
