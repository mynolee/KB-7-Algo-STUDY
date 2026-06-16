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

            int gcd = gcd(Math.max(a, b), Math.min(a, b));
            int lcm = a * b / gcd;

            bw.write(String.valueOf(lcm));
            bw.newLine();
        }

        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}