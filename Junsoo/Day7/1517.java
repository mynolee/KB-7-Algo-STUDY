import java.util.*;
import java.io.*;

public class Main {
    public static int[] A, temp;
    public static long result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        temp = new int[N + 1];

        // 이렇게 작성해도 문제 없어야될 것 같은데 런타임 에러 나옴 NoSuchElementException
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//        }

        // 그래서 gpt 풀이로 그냥 추가함
        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(1, N);
        System.out.println(result);
    }

    private static void merge_sort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(left, mid);
        merge_sort(mid + 1, right);

        int i = left; // 왼쪽 부분 배열의 현재 인덱스 (left ~ mid 범위)
        int j = mid + 1; // 오른쪽 부분 배열의 현재 인덱스 (mid + 1 ~ right 범위)
        int k = left; // 정렬된 값을 임시 배열 temp에 저장할 인덱스

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k] = A[i]; // 왼쪽 값이 더 작거나 같으면 temp에 넣고 i, k 증가
                k++;
                i++;
            } else {
                temp[k] = A[j]; // 오른쪽 값이 더 작으면 temp에 넣고 j, k 증가
                // 왼쪽 부분 배열에 남은 값들은 모두 A[j]보다 크므로 swap 횟수 증가
                result += mid - i + 1;
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = A[i]; // 오른쪽 부분 배열은 모두 처리, 왼쪽 부분 배열에 남은 값들 temp에 복사
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = A[j]; // 왼쪽 부분 배열은 모두 처리, 오른쪽 부분 배열에 남은 값들 temp에 복사
            k++;
            j++;
        }

        for (int l = left; l <= right; l++) {
            A[l] = temp[l]; // 정렬된 결과를 원본 배열에 반영
        }
    }
}
