import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.print(sb);
    }

    static void dfs(int number, int length) {
        if (length == N) {
            sb.append(number).append('\n');
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int next = number * 10 + i;

            if (isPrime(next)) {
                dfs(next, length + 1);
            }
        }
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}