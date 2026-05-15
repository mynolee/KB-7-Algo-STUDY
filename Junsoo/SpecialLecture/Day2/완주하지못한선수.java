import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        // 마지막 인덱스까지 해도 정답이 나오지 않으면 마지막 인덱스 이름 출력
        return participant[participant.length - 1];
    }
}
