import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        int[] A = new int[nA];
        int[] B = new int[nB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        StringBuilder answer = new StringBuilder();
        int count = 0;

        for (int num : A) {
            if (Arrays.binarySearch(B, num) < 0) {
                answer.append(num).append(' ');
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');

        if (count > 0) {
            sb.append(answer);
        }

        System.out.print(sb);
    }
}