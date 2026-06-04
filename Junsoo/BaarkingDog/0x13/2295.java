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

        for (int d = n - 1; d >= 0; d--) {
            for (int c = d - 1; c >= 0; c--) {
                // left: a, right: b 역할
                int left = 0;
                int right = n - 1;

                while (left <= right) {
                    // arr[left] + arr[right] + arr[c] = arr[d]를 찾아야 함
                    int sum = arr[left] + arr[right] + arr[c];
                    if (sum == arr[d]) {
                        System.out.println(arr[d]);
                        return;
                    }

                    if (sum < arr[d]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
    }
}
