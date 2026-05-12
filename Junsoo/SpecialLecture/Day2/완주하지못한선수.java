import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // completion 배열에 있는 이름을 HashMap의 키에 저장 후 중복 이름 횟수를 value로 저장
        Map<String, Integer> map = new HashMap<>();
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // participant의 이름 중 map에 없거나 value가 0인 사람은 완주하지 못한 것
        for (String name : participant) {
            if (!map.containsKey(name) || map.get(name) == 0) {
                return name;
            }
            map.put(name, map.get(name) - 1);
        }
        return "";
    }
}
