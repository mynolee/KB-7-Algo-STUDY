import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        ArrayList<Integer> sum = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sum);

        for (int i = N - 1; i >= 0; i--) {

            for (int j = 0; j < N; j++) {

                int target = arr[i] - arr[j];

                if (Collections.binarySearch(sum, target) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}