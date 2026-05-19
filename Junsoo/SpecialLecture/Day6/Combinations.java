import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int start, int n, int k, List<Integer> cur, List<List<Integer>> answer) {
        if (cur.size() == k) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(i + 1, n, k, cur, answer);
            cur.remove(cur.size() - 1);
        }
    }
}
