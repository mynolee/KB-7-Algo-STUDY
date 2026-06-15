import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isNotSqaureNoNo = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = min / square;  // min 이상으로 만들기 위한 제곱수에 곱할 시작 숫자

            // 나머지 존재하는 경우
            if (min % square != 0) {
                start++;
            }
            for (long j = start; square * j <= max; j++) {
                long curNum = square * j;

                // 상대 위치(오프셋) 인덱스 사용 (왜냐면 worst case에서 메모리 초과 날 수 있음)
                isNotSqaureNoNo[(int) (curNum - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!isNotSqaureNoNo[i]) count++;
        }

        System.out.println(count);
    }
}
