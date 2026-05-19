import java.util.*;

class Solution {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int cur, int index) {
        if (index == numbers.length) {
            if (cur == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, cur + numbers[index], index + 1);
        dfs(numbers, target, cur - numbers[index], index + 1);
    }
}
