import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        int next = 1;

        for (int i = 0; i < n; i++) {

            int target = Integer.parseInt(br.readLine());

            for (; next <= target; next++) {

                stack.push(next);

                sb.append("+\n");

            }

            if (stack.peek() == target) {

                stack.pop();

                sb.append("-\n");

            } else {

                System.out.println("NO");

                return;

            }

        }

        System.out.print(sb);

    }

}