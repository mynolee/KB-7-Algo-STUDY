import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nA; i++) {
            if (Arrays.binarySearch(B, A[i]) < 0) {    // 존재 안하면
                count++;
                sb.append(A[i]).append(" ");
            } else {
                continue;
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
