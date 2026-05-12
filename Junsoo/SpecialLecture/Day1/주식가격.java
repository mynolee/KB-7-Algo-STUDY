import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 아직 가격이 떨어지지 않은 인덱스 저장
//        Stack<Integer> st = new Stack<>();
//        for (int i = 0; i < prices.length; i++) {
//            while (!st.isEmpty() && prices[i] < prices[st.peek()]) {
//                int prevIdx = st.pop();
//                answer[prevIdx] = i - prevIdx;
//            }
//            st.push(i);
//        }
//        while (!st.isEmpty()) {
//            int prevIdx = st.pop();
//            answer[prevIdx] = prices.length - prevIdx - 1;
//        }

        // 자바로는 2중 for문이 효율성 더 좋게 나옴
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }
        return answer;
    }
}
