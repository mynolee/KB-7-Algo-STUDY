import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean result = true;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {    // arr[i] < num
                int x = stack.pop();
                if (x > arr[i]) {
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (!result) System.out.println("NO");
        else System.out.println(sb);
    }


}
