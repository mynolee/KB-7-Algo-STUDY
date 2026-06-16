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

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            bw.write(String.valueOf(lcm(a, b)));
            bw.newLine();
        }

        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    // 최소공배수를 구하는 함수
    private static int lcm(int a, int b) {
        int min = Math.min(a, b);

        int gcd = 1;
        // 1부터 a,b 중 더 작은 수까지 a, b를 나눠보면서 최대공약수를 구한다.
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) gcd = i;
        }

        // 최소공배수는 최대공약수 * (a / 최대공약수) * (b / 최대공약수)가 되므로
        // a * b / 최대공약수를 리턴하면 된다.
        return a * b / gcd;
    }
}