import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        Character[] arr = new Character[n.length()];

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}