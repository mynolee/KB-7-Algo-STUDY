import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());   // 비번 길이

        String str = br.readLine(); // CCTGGATTG

        // 하나씩 넣기
        st = new StringTokenizer(br.readLine());
        int[] acgt = new int[4];
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        // 비교할 배열 하나 만들기
        int[] compare = new int[4];
        int count = 0;

        // 첫 번째 길이 P 구간의 문자 개수 세기
        for (int i = 0; i < P; i++) {
            addChar(compare, str.charAt(i));
        }

        if (isValid(acgt, compare)) {
            count++;
        }

        // 윈도우를 한 칸씩 오른쪽으로 이동
        for (int start = 1; start + P - 1 < S; start++) {
            int end = start + P - 1;

            removeChar(compare, str.charAt(start - 1));
            addChar(compare, str.charAt(end));

            if (isValid(acgt, compare)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void addChar(int[] compare, char c) {
        switch (c) {
            case 'A':
                compare[0]++;
                break;
            case 'C':
                compare[1]++;
                break;
            case 'G':
                compare[2]++;
                break;
            case 'T':
                compare[3]++;
                break;
        }
    }

    static void removeChar(int[] compare, char c) {
        switch (c) {
            case 'A':
                compare[0]--;
                break;
            case 'C':
                compare[1]--;
                break;
            case 'G':
                compare[2]--;
                break;
            case 'T':
                compare[3]--;
                break;
        }
    }

    static boolean isValid(int[] acgt, int[] compare) {
        for (int i = 0; i < 4; i++) {
            if (compare[i] < acgt[i]) {
                return false;
            }
        }
        return true;
    }
}