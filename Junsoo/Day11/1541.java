import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아이디어: (-) 뒤에 나온 모든 (+) 연산을 먼저 수행하게 해서 뺄 값을 최대로 만듦
        // => 모든 (+) 연산에 괄호를 묶어 먼저 연산하면 됨
        String expr = br.readLine();
        String[] subExpr = expr.split("-");

        int answer = 0;
        for (int i = 0; i < subExpr.length; i++) {
            // +는 정규식에서 특별한 의미를 가진 문자라서 \\+처럼 이스케이프 필요
            // "+" 이스케이프 하기 위한 "\", 역슬래시 "\"도 이스케이프가 필요해서 "\\"로 써야 함
            String[] sumStr = subExpr[i].split("\\+");

            int sum = 0;
            for (int j = 0; j < sumStr.length; j++) {
                sum += Integer.parseInt(sumStr[j]);
            }

            // 맨 처음 그룹만 더하고 나머지 그룹은 빼야 함
            if (i == 0) {
                answer += sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}
