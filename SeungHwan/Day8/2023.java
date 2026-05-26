import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 1자릿수 소수는 2, 3, 5, 7
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        
        System.out.println(sb.toString());
    }

    private static void dfs(int num, int len) {
        // 길이가 n 도달하면 sb에 추가하고 리턴
        if(len == n) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            if (i == 5) continue;

            int nextNum = num * 10 + i;

            if (isPrime(nextNum)) {
                dfs(nextNum, len + 1);
            }
        }

    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
