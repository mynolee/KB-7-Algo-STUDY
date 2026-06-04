import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] twoSum = new int[n * n];
        int index = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                twoSum[index] = arr[a] + arr[b];
                index++;
            }
        }
        Arrays.sort(twoSum);

        for (int d = n - 1; d >= 0; d--) {
            for (int c = 0; c < n; c++) {
                if (Arrays.binarySearch(twoSum, arr[d] - arr[c]) >= 0) {
                    System.out.println(arr[d]);
                    return;
                }
            }
        }
    }
}
