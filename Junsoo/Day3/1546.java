import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int score = scanner.nextInt();
            sum += score;
            if (score > max) {
                max = score;
            }
        }
        double avg = (double) sum / N;
        double newAvg = avg / max * 100;

        System.out.println(newAvg);
    }
}
