import java.util.*;

class Solution {
    // 만들 수 있는 소수만 중복 없이 저장하는 Set
    private Set<Integer> primeSet = new HashSet<>();
    
    public int solution(String numbers) {
        // 각 숫자 조각 사용했는지 확인하는 배열
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);
        return primeSet.size();
    }

    private void dfs(String numbers, String cur, boolean[] visited) {
        if (cur.length() != 0) {
            int num = Integer.parseInt(cur);
            if (isPrime(num)) {
                primeSet.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, cur + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
