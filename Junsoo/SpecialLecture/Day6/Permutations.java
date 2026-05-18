import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), visited, answer);
        return answer;
    }

    private void dfs(int[] nums, List<Integer> cur, boolean[] visited, List<List<Integer>> answer) {
        if (cur.size() == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, cur, visited, answer);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
