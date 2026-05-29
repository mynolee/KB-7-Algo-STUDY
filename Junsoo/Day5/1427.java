import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자를 문자열로 입력 받은 후 문자 배열로 변환
        String n = br.readLine();
        char[] arr = n.toCharArray();
        Arrays.sort(arr);

        // 오름차순 정렬한 뒤 뒤에서부터 출력하면 내림차순 정렬 됨
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);

        // 추가 풀이
        // 계수 정렬로도 가능 (0~9가 각각 몇 개 나왔는지)
//        int[] count = new int [10];
//        String n = br.readLine();
//
//        // 각 숫자에 해당하는 자리 + 1
//        for (int i = 0; i < n.length(); i++) {
//            int num = n.charAt(i) - '0';
//            count[num]++;
//        }
//        // 각 숫자 개수만큼 9부터 0까지 역순으로 출력
//        StringBuilder sb = new StringBuilder();
//        for (int i = 9; i >= 0 ; i--) {
//            while (count[i] > 0) {
//                sb.append(i);
//                count[i]--;
//            }
//        }
//        System.out.println(sb);
    }
}
