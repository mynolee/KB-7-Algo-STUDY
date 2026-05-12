import java.util.*;
import java.io.*;

public class Main {
    // 숫자의 값과 원래 인덱스를 함께 저장하기 위한 클래스
    static class Number implements Comparable<Number> {
        int value; // 실제 숫자 값
        int index; // 정렬 전 원래 인덱스

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }

        // Arrays.sort()가 Number객체 정렬하는 기준, value 기준 오름차순
        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Number[] arr = new Number[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Number(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);

        int maxMove = 0;
        for (int i = 0; i < N; i++) {
            // 정렬 전 위치 - 정렬 후 위치가 양수면 왼쪽으로 이동한 것
            // 가장 많이 왼쪽으로 이동한 값 저장
            maxMove = Math.max(maxMove, arr[i].index - i);
        }

        // 버블 정렬은 정렬 끝난 뒤 swap이 있는지 한번 더 검사하므로 회차 번호는 +1
        System.out.print(maxMove + 1);
    }
}
