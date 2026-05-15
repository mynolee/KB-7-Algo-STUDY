import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계: 소문자 치환
        new_id = new_id.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();

        // 3단계: 연속된 마침표 하나로 치환
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        // 4단계: 처음과 끝의 마침표 제거
        if (!new_id.isEmpty() && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5단계: 빈 문자열이면 "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6단계: 길이 16이상이면 앞 15만 남기고 마침표로 끝나면 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 7단계: 길이 2이하면 길이 3 될 때까지 마지막 문자 끝에 붙임
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
}
