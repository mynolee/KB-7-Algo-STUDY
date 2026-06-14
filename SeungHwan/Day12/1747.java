import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while (true) {
            if (isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                break;
            }
            N++;
        }
        
    }

    private static boolean isPrime (int num) {
        if (num <= 1) return false;
        else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome (int N) {
        String str = String.valueOf(N);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) return false;
        }

        return true;
    }
}
