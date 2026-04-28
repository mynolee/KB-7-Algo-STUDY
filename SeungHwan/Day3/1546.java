import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = arr[N - 1];
        double[] newArr = new double[N];
        double sum = 0;
        for (int i = 0; i < N; i++) {
            newArr[i] = (double) arr[i] / M * 100;
            sum += newArr[i];
        }

        double avg = sum / N;
        System.out.println(avg);
    }
}
