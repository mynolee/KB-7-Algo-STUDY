import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // <숫자, 인덱스>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 현재 숫자와 target을 만들기 위해 필요한 수 needed 구함
            int needed = target - nums[i];
            if (map.containsKey(needed)) {
                // 이미 needed가 map에 존재하면 한 쌍 찾은 것이므로 리턴
                // 이미 저장되어 있던 needed의 인덱스가 더 빠를 것이므로 먼저 리턴
                return new int[]{map.get(needed), i};
            }
            // map에 없으면 우선 map에 추가하고 다음 숫자 탐색
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
