import java.util.*;
import java.io.*;

public class Main {
    /*
    굳이 2차원 배열 만들 필요 없이, row 1차원 배열 하나로 표현 가능
    -> 어차피 1row당 한개씩 밖에 배치 못함.

    따라서 첫번째 열부터 배치하는 방식으로 백트래킹
    */
    static int[] row;
    static int answer;
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        row = new int[n];
        answer = 0;
        backtrack(0);

        System.out.println(answer);
    }

    private static void backtrack(int current) {
        if (current == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            row[current] = i;

            if(isPossible(current)) {
                backtrack(current + 1);    
            }
        }
    }

    private static boolean isPossible(int current) {
        for (int i = 0; i < current; i++) {
            // 1. 같은 열에 퀸이 있는지 확인
            if (row[i] == row[current]) return false;

            // 2. 대각선에 퀸 있는지 확인
            if (Math.abs(row[i] - row[current]) == Math.abs(i - current)) return false;
        }

        return true;
    }
}
