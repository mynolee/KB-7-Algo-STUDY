import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevTempIdx = st.pop();
                answer[prevTempIdx] = i - prevTempIdx;
            }
            st.push(i);
        }
        // 더 따뜻한 날이 오지 않는 남은 날은 기본적으로 answer이 0으로 초기화되어 있으므로 상관 없음
        return answer;
    }
}
