import java.util.*;
import java.io.*;

public class Main {
    // 메서드 사용하기 위해 필드로 뺌
    static int[] required = new int[4];
    static int[] current = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        // 처음 P만큼 부분문자열에 넣어놓고 하나씩 배면서 판단
        for (int i = 0; i < P; i++) {
            current[getIndex(dna[i])]++;
        }
        if (isValid()) {
            answer++;
        }

        for (int i = P; i < S; i++) {
            // 현재 문자를 부분문자열에 추가
            current[getIndex(dna[i])]++;
            // 기존 맨앞 문자를 부분문자열에서 제거
            current[getIndex(dna[i - P])]--;
            if (isValid()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    // 해당 DNA 문자에 해당하는 인덱스 반환 함수
    static int getIndex(char c) {
        if(c=='A') return 0;
        if(c=='C') return 1;
        if(c=='G') return 2;
        return 3;
    }

    // 현재 부분문자열이 비밀번호로 사용 가능한지 판단하는 함수
    static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}
