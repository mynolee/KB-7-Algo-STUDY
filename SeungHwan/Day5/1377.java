import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = new Node(val, i);
        }

        Arrays.sort(arr, (a, b) -> a.value - b.value);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i].index - i);
        }

        System.out.println(max + 1);
    }
}
