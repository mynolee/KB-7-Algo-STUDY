import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 호제법을 써야하는데 long 범위를 초과하기 때문에 메서드로 계산할 수가 없다.
        // 1로만 구성돼있기 때문에 뭔가 다른 특징이 있을 것이다.
        // 11111111 % 11을 해보자. 11로 11000000을 만들 수 있으니까
        // 111111 % 11이 된다. 11로 110000을 만들 수 있으니까
        // 1111 % 11이 된다. 11로 1100을 만들 수 있으니까
        // 11 % 11이 된다. => 나누어 떨어진다.

        // 규칙을 찾았다. 1이 8개 % 1이 2개일때 8에서 2를 뺄 수 있을 때까지 빼는 것이다.
        // 딱 떨어지면 바로 최대공약수가 나오는 것이고
        // 그렇지 않으면 호제법에 따라 또 나눠야 한다.
        // 이것을 메서드로 만들 수 있을 것 같다.
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long big = Math.max(a, b);
        long small = Math.min(a, b);

        for (int i = 0; i < gcd(big, small); i++) {
            bw.write("1");
        }
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static long gcd(long a, long b) {
        a = a - (a / b) * b;
        return a == 0 ? b : gcd(b, a);
    }
}