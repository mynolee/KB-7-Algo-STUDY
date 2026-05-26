import java.io.*;
import java.nio.Buffer;
import java.text.FieldPosition;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();

        if (n == 1) {
            pw.println(2);
            pw.println(3);
            pw.println(5);
            pw.println(7);

            br.close();
            pw.flush();
            pw.close();
            
            return;
        }

        for (int i = 1; i <= 9; i++) q.offer(i);
        while (!q.isEmpty()) {
            int num = q.poll();

            if (isPrime(num)) {
                num *= 10;
                for (int j = num + 1; j < num + 10; j++) {
                    if (isPrime(j)) {
                        if (j > (int) Math.pow(10, n - 1)) pw.println(j);
                        else q.offer(j);
                    }
                }
            }
        }

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

/*
abcdedfg가 신기한 소수인지 알아내려면 8번 isPrime을 실행해야 함
isPrime은 O(루트 n)임
모든 8자리 숫자를 검증한다고 하면 숫자가 1억개이고 각각 루트 1억만큼 걸리니까 1억루트1억
시간초과가 날 것이 분명하다.

일단 한자리에서는 2 3 5 7이 된다.
2 -> 21 22 23 ~ 29
그리고 각각에서
211 ~
 */