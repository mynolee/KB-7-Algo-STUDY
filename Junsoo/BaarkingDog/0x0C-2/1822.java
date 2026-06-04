import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        int[] a = new int[aSize];
        int[] b = new int[bSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        Arrays.sort(b);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < aSize; i++) {
            if (Arrays.binarySearch(b, a[i]) < 0) {
                count++;
                answer.add(a[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Collections.sort(answer);
        for (int num : answer) {
            sb.append(num).append(" ");
        }        
        System.out.println(sb);
    }
}
