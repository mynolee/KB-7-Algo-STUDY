import java.util.*;

class Solution {
    private List<List<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        for (int size = 1; size <= relation[0].length; size++) {
            dfs(relation, new ArrayList<>(), 0, size);
        }
        return candidateKeys.size();
    }
    private void dfs(String[][] relation, List<Integer> cur, int start, int size) {
        if (cur.size() == size) {
            if (isMinimal(cur) && isUnique(relation, cur)) {
                candidateKeys.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i < relation[0].length; i++) {
            cur.add(i);
            dfs(relation, cur, i + 1, size);
            cur.remove(cur.size() - 1);
        }
    }

    private boolean isMinimal(List<Integer> cur) {
        // 이미 후보키로 등록된 key가 현재 조합에 모두 포함되어 있으면 최소성 위반
        for (List<Integer> key : candidateKeys) {
            if (cur.containsAll(key)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(String[][] relation, List<Integer> cur) {
        Set<String> set = new HashSet<>();
        // 각 row마다 선택된 컬럼 값들을 하나로 묶어서 Set에 저장
        for (int row = 0; row < relation.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col : cur) {
                sb.append(relation[row][col]).append("|");
            }
            set.add(sb.toString());
        }
        // Set 크기가 row 개수와 같으면 모든 튜플을 유일하게 구분 가능
        return set.size() == relation.length;
    }
}
