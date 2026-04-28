import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String numStr = scanner.next();

        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += (numStr.charAt(i) - '0');
        }
        System.out.println(sum);
    }
}
