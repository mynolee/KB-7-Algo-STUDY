import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());

        long sum = 0;
        long answer = 0;

        count[0] = 1;

        for (int i = 0; i < N; i++) {

            sum += Integer.parseInt(st.nextToken());

            int remainder = (int)(sum % M);

            answer += count[remainder];

            count[remainder]++;
        }

        System.out.println(answer);
    }
}