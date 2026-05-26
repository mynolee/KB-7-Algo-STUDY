import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 한 자리 수 중에 소수인 경우는 2, 3, 5, 7
        dfs(n, 2, 1);
        dfs(n, 3, 1);
        dfs(n, 5, 1);
        dfs(n, 7, 1);
        System.out.print(sb);
    }

    //
    private static void dfs(int n, int cur, int length) {
        if (length == n) {
            sb.append(cur).append("\n");
            return;
        }
        // 짝수인 경우는 절대 소수가 될 수 없으므로 건너뛰게끔 2씩 더함
        for (int i = 1; i < 10; i += 2) {
            int next = cur * 10 + i;
            if (isPrime(next)) {
                dfs(n, next, length + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
