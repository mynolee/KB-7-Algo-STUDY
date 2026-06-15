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
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        final int LEN = 10000000;
        boolean[] arr = new boolean[LEN];

        // 9,999,999 길이의 소수 여부 배열을 만든다.
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i * i < LEN; i++) {
            if (arr[i] == false) continue;

            int ik = i + i;
            while (ik < LEN) {
                arr[ik] = false;
                ik += i;
            }
        }

        // 주어진 n에 대해서 팰린드롬 수를 제일 낮은 것부터 찾아낸다.
        // 소수라면 정답이 된다.
        int pel = n;
        while (true) {
            if (arr[pel] == true && isPel(pel)) break;
            pel++;
        }

        bw.write(sb.append(pel).toString());

        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    private static boolean isPel(int n) {
        String s = String.valueOf(n);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }
}