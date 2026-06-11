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
        String formula = st.nextToken();

        int sum = 0;
        int temp = 0;
        boolean isSub = false;
        int idx = 0;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '-' || c == '+') {
                int num = Integer.parseInt(formula.substring(idx, i));
                idx = i + 1;

                if (c == '-' && isSub) {
                    temp += num;
                } else if (c == '-' && !isSub) {
                    sum += temp + num;
                    temp = 0;
                    isSub = true;
                } else if (c == '+' && isSub) {
                    temp += num;
                } else if (c == '+' && !isSub) {
                    sum += temp + num;
                    temp = 0;
                }
            }

            if (i == formula.length() - 1) {
                int num = Integer.parseInt(formula.substring(idx));
                if (isSub) sum -= temp + num;
                else sum += temp + num;
            }
        }

        bw.write(sb.append(sum).toString());
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}