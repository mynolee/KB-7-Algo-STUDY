import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        // 원하는 코스 메뉴 길이별로 반복
        for (int size : course) {
            // 현재 size 길이의 메뉴 조합별 등장 횟수 저장
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                // 정렬하기 위해 문자열을 문자 배열로 변환
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                // 주문 메뉴 개수가 size보다 작으면 조합 만들 수 X
                if (chars.length < size) {
                    continue;
                }
                // 혀냊 주문에서 size개짜리 메뉴 조합 생성
                dfs(chars, map, size, 0, "");
            }
            int maxCount = 0;
            for (int count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }
            // 최소 2명 이상의 손님에게 주문한 조합만 코스 후보 가능
            if (maxCount >= 2) {
                for (String menu : map.keySet()) {
                    if (map.get(menu) == maxCount) {
                        answer.add(menu);
                    }
                }
            }
        }
        // 정답은 사전순으로 정렬
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void dfs(char[] chars, Map<String, Integer> map, int size, int start, String cur) {
        if (cur.length() == size) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            // 현재 메뉴 chars[i] 선택, 다음 메뉴는 i+1부터 선택해서 조합 생성
            dfs(chars, map, size, i + 1, cur + chars[i]);
        }
    }
}
