import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // N이 최대 10,000,000 이므로 모든 숫자를 정렬하여 Arrays.sort()를 사용하는 것은 불가
        // 입력되는 숫자 개수가 작으므로 숫자 출현 횟수를 저장하여 계수 정렬
        int N = Integer.parseInt(br.readLine());
        // 숫자 크기가 10,000 이하이므로 숫자 개수 배열 크기는 숫자 그대로 인덱스 사용하기 위해 10001
        int[] count = new int[10001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }
        
        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }
        System.out.print(sb);
    }
}
